package learn.queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/20
 * Time: 9:29
 */
public class ArrayQueue<E>  implements Queue<E>{
    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }
    @Override
    public void offer(E e) {
        array.addLast(e);
    }

    @Override
    public E poll(E e) {
        return array.removeFirst();
    }

    @Override
    public E front() {

        return array.getFirst();
    }

    @Override
    public E back() {
        return array.getLast();
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("queue:");
        res.append("front : [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(array.getSize() - 1 != i)
                res.append(", ");
        }
        res.append("] back");
        return res.toString();
    }
}
