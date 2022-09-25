package learn.unionfie;

import java.nio.BufferUnderflowException;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/23
 * Time: 14:47
 * 基于size的优化是可以用来解决集合中的数量问题s
 */
public class UnoinFind1 implements UF{
    private int [] id;
    public UnoinFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    private int find(int p){
        if(p < 0 || p >= id.length) throw new RuntimeException("p is out of index");
        return id[p];
    }
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) return ;

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId) id[i] = qId;
        }
    }
}
