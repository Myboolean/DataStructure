package learn.unionfie;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/23
 * Time: 14:31
 */
public interface UF {
    int size();
    boolean isConnected(int p ,int q);

    void unionElements(int p, int q);
}
