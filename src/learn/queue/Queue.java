package learn.queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/19
 * Time: 22:23
 */
public interface Queue<E> {
    void offer(E e);
    E poll(E e);
    E front();
    E back();
    int size();
    boolean isEmpty();

}
