package learn.queue;

import java.security.PublicKey;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/20
 * Time: 9:57
 */
public class LoopQueue<E> implements Queue<E> {

    int front = 0;
    int tail = 0;
    int size = 0;
    private E[] data;

    public LoopQueue (int capacity){
        data =(E[]) new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void offer(E e) {
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail +  1) % data.length;
        size ++ ;
    }
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length]; // 把front置为0所在的位置
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E poll(E e) {
        if(isEmpty())
            return null;
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size < getCapacity() / 4) resize(getCapacity() / 2);
        return res;
    }

    @Override
    public E front() {
        return data[front];
    }

    @Override
    public E back() {
        return data[tail];
    }

    @Override
    public int size() {
        return this.size;
    }
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("queue:");
        res.append("front : [");
        for(int i = front ; i != tail ; i = (i +  1) % data.length){  // 变遍历循环队列
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] back");
        return res.toString();
    }
}
