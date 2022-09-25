package learn.segementtree;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 20:05
 * 线段树
 * 对一个区间进行操作// 懒惰更新 ， lazy数组距离结点未更新，等需要访问结点的值（再次更新或者查询）的时候，进行更新
 *
 */
public class SegementTree<E> {

    private final E[] data;
    private final E[] tree;
    private final Merger<E> merger;
    public SegementTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegementTree(0, 0, data.length - 1);
    }

    private void buildSegementTree(int treeIndex, int l, int r) {
        if(l  == r )  {
            tree[treeIndex] = data[l];
            return ;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegementTree(leftTreeIndex, l, mid);
        buildSegementTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }
    public void set(int index, E val){

    }
    private void set(int treeIndex, int l, int r, int index , E val){
        if(l == r){
            tree[treeIndex] = val;
            return ;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l  + (r - l) / 2;
        if(index >= mid + 1) set(rightTreeIndex, mid + 1, r, index, val);
        else set(leftTreeIndex, l, mid, index, val);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    public int size(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length) throw new RuntimeException("index is illegal");
        return data[index];
    }

    // 返回完全二叉树数组表示中，一个索引所表示的元素的左孩子结点索引
    public int leftChild(int index){
        if(index < 0 || index >= data.length) throw new RuntimeException("index is illegal");
        return index * 2  + 1;
    }

    // 返回完全二叉树数组表示中，一个索引所表示的元素的右孩子结点索引
    public int rightChild(int index){
        if(index < 0 || index >= data.length) throw new RuntimeException("index is illegal");
        return index * 2  + 2;
    }

    /**
     * @param l 左端点
     * @param r 右端点
     * @return 返回 [l, r]线段树存储的值
     */
    public E query(int l, int r){
        if(l < 0 || l >= data.length || r < 0 || r >= data.length) throw new RuntimeException("index is illegal");
        return query(0, 0, data.length - 1, l ,r );
    }

    /**
     *
     * @param treeIndex 在treeI为线段树中的[L,R]范围内所搜区间【queryL，queryR】的值
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l,int r, int queryL, int queryR){
        if(l == queryL && r == queryR) return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int lefTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL >= mid + 1) return  query(rightTreeIndex,mid + 1, r, queryL, queryR);
        else if(queryR <= mid) return query(lefTreeIndex, l , mid ,queryL, queryR);
        E lr = query(lefTreeIndex,l, mid ,queryL, mid);
        E rr = query(rightTreeIndex, mid + 1, r, mid + 1, queryR );
        return merger.merge(lr, rr);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null) stringBuilder.append(tree[i]);
            else stringBuilder.append("null");

            if(i != tree.length - 1){
                stringBuilder.append(" ");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
