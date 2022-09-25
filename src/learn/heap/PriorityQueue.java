package learn.heap;

import learn.queue.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 16:36
 */
public class PriorityQueue <E extends Comparable<E>> implements Queue<E> {
    MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    @Override
    public void offer(E o) {
        maxHeap.add(o);
    }

    @Override
    public E poll(E o) {
        return maxHeap.extractMax();
    }

    @Override
    public E front() {
        return maxHeap.findMax();
    }

    @Override
    public E back() {
        return null;
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
