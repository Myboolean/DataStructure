package learn.unionfie;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/23
 * Time: 19:49
    将每一个元素，看做是一个结点
    rank是用高度来排序
 */
public class QuickUnion implements UF{
    private int[] parent;
    private int[]  rank;
    public QuickUnion(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int p){
        if(p < 0 || p >= parent.length) throw new RuntimeException("p is out of index");
        while(p != parent[p]) p = parent[p];
        return p;
    }

    /**
     * 路径压缩，性能是最好的
     * @param p
     * @return
     */
    private int findMax(int p){
        if(p != parent[p]) p = find(p);
        return p;
    }
    /**
     * 基于rank的优化
     * @param p
     * @param q
     */
    private void unionElementByRank(int p , int q){

    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if(pID == qID) return;
        if(rank[pID] < rank[qID]){
            parent[pID] = qID;
//            rank[qID] = Math.max(rank[qID], rank[pID] + 1 );
            // 因为q的高度的子树高度大于等于p的树的高度
        } else if(rank[pID] >  rank[qID]) {
            parent[qID] = pID;
        }
        else {
            parent[qID] = pID;
            rank[pID] +=1;
        }
        parent[pID] = qID;
    }
}
