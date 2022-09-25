package learn.setandmap.setbasic;

import learn.tree.BinarySearchTree;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 8:34
 */
public class BSTSet <E extends Comparable<E>> implements Set<E>{
    BinarySearchTree<E> bst;
    public BSTSet(){
        bst = new BinarySearchTree<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.deleteAnyNode(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int size() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
