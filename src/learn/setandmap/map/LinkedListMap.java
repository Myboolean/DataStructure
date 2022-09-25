package learn.setandmap.map;

import learn.tree.BinarySearchTree;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 9:20
 */
public class LinkedListMap <K,V> implements Map<K,V>{

    public class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){
            this(key, null, null);
        }
        public Node(){
            this(null, null,null);
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else {
//            throw new RuntimeException("key已经存在");
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)) break;
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }
    private Node getNode(K key){
        Node vur = dummyHead.next;
        while (vur != null){
            if(vur.key.equals(key)) return vur;
            vur = vur.next;
        }
        return null;
    }
    @Override
    public V get(K key) {
        if(getNode(key) != null){
            return Objects.requireNonNull(getNode(key)).value;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null){
//            add(key, newValue);
                throw new RuntimeException(key + "doesn't exist");
        }else {

            node.value = newValue;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
