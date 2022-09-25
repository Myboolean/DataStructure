package learn.setandmap.setbasic;

import learn.linkedlist.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 8:52
 */
public class LinkedListSet<E> implements Set<E>{
    LinkedList<E> list;


    public LinkedListSet(){
        list = new LinkedList<>();
    }
    @Override
    public void add(E e) {
        if(!contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
