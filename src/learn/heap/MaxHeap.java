package learn.heap;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 15:30
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }
    public MaxHeap(E [] arr){
        data = new Array<>(arr);
        // 时间复杂度为O（n）
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            down(i);
        }

    }
    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if(index == 0)
            throw new RuntimeException("index-0 dosen't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        if(index < 0) throw new RuntimeException("index-"+index+" < 0");
        return index * 2 + 1;
    }
    private int rightChild(int index){
        if(index < 0) throw new RuntimeException("index-"+index+" < 0");
        return index * 2 + 2;
    }
    //堆中添加元素
    public void add(E e){
        data.addLast(e);
        up(data.getSize() - 1);
    }

    public void up(int u){
        while(u > 0 && data.get(parent(u)).compareTo(data.get(u)) < 0){
            data.swap(u , parent(u));
            u = parent(u);
        }
    }
    public E findMax(){
        if(data.getSize() == 0) throw new RuntimeException("can not find max while heap is empty");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax(){
        if(data.getSize() == 0) throw new RuntimeException("can not find max while heap is empty");
        E e = data.get(0);
        data.set(0, data.get(data.getSize() - 1));
        down(0);
        return e;
    }

    public void down(int u){

        while(leftChild(u) < data.getSize()){
            int j = leftChild(u); // 左孩子
            if(j + 1 < data.getSize() && data.get(j +1).compareTo(data.get(j)) > 0){
                j++;
            }
            if(data.get(u).compareTo(data.get(j)) >= 0) break;

            data.swap(u, j);
            u = j;
        }
    }

    /**
     * 将任意数组整理成堆的形状
     */
    public void heapify(){
        for(int i = 0 ; i < (data.getSize() - 1) / 2;i++){
            down(i);
        }
    }

    /**
     * 取出最大元素,放入一个新元素
     */
    public E replace (E e){
        E se = data.get(0);
        data.set(0, e);
        down(0);
        return se;
    }
}
