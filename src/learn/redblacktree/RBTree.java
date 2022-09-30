package learn.redblacktree;

import learn.setandmap.map.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 10:37
 * // 有序映射基于搜索树，更进一步红黑树， 无序映射基于hash
 * 基于map实现set, value为空即可
 */
public class RBTree<K extends Comparable<K>, V>  {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public class Node{
        public K key;
        public V value;
        public boolean color; // 保存结点的颜色, true 代表红色，false代表黑色
        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            color = RED;
        }
        public Node(K key, V value){
            this(key, value, null, null);
        }
    }
    private Node root;
    int size;

    public RBTree(){
        root = null;
        size = 0;
    }


    public void add(K key, V value) {
        root = add(root, key ,value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null){
            size++;
            return  new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }
        return node;
    }


    public V remove(K key) {
        Node node1 = getNode(root, key);
        if(node1 != null){
            root = remove(root, key);
            return node1.value;
        }
        return null;
    }

    /**
     * 删除以node为根的二分搜索树中的最小结点
     * 返回删除结点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node deleteNodeMin(Node node) {
        if(node == null){
            return  null;
        }

        if(node.left == null){
            Node leftNode = node.right;
            node.right = null; // 删除node 的右子树从树中脱离出来
            size --;
            return leftNode;
        }

        node.left = deleteNodeMin(node.left);
        return node;
    }
    public K minimum(){
        if(size == 0) return  null;
        return minimum(root).key;
    }
    private Node minimum(Node node) {
        if(node.left == null) return node;
        return minimum(node.left);
    }

    /**
     * 删除任意结点
     * @return
     */
    public void deleteAnyNode(K key){
        root = remove(root, key);
    }

    /**
     * 删除以node为根的二分搜素诺书中值为e的方法，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param
     * @return
     */
    private Node remove(Node node, K key) {
        if(node == null) return null;

        if(key.compareTo(node.key) < 0) return remove(node.left, key);
        else if(key.compareTo(node.key) > 0) return remove(node.right, key);
        else {


            if( node.left == null) { // 没有左孩子
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null){ // 没有右孩子
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node cur = minimum(node.right);
            cur.right = deleteNodeMin(node.right); // 这里size不用减，因为找到的节点变成了当前子树的根节点,代替当前被删除的位置
            size++;
            cur.left = node.left;
            node.left = node.right =null; //删除node结点
            return cur;


        }
    }

    public boolean contains(K key) {

        return contains(root, key);
    }
    private Node getNode(Node node, K key){
        if(node == null) return null;
        if(key.compareTo(node.key) < 0) return getNode(node.left, key);
        if(key.compareTo(node.key) > 0) return getNode(node.right, key);
        return node;
    }
    private boolean contains(Node node, K key) {
        Node node1 = getNode(node, key);

        return node1 != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null) throw new RuntimeException(key + "doesn't exist");

        node.value = newValue;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
