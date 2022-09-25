package learn.avl;


import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/21
 * Time: 9:26
 * 不包含重复元素的二分搜索树
 */
public class AVLTree<E extends Comparable<E>>{

    public class Node {
        public E e;
        public int height;
        public Node left, right;

        public Node(E e){
            this.e = e;
            this.height = 0;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 中序遍历判断`
     * @return
     */
    public boolean isBST(){
        ArrayList<E> es = new ArrayList<>();
        inOrder(root, es);
        for(int i = 1 ; i < es.size();i++)
            if(es.get(i-1).compareTo(es.get(i)) > 0) return  false;

        return true;
    }

    /**
     * 是否平衡
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);

    }

    /**
     * 中序遍历存储序列
     * @param node
     * @param es
     */
    private void inOrder(Node node,ArrayList<E> es ){
        if(node == null) return;
        inOrder(node.left);
        es.add(node.e);
        inOrder(node.right);
    }


    private int getHeight(Node node){
        if(node ==null) return 0;
        return node.height;
    }
    /**
     * 计算平很因子
     */
    private int getBalanceFactor(Node node){
        if(node == null) return  0;
        return getHeight(node.left) - getHeight(node.right);
    }
    /**
     * 以node为根的二分搜索树传入E，递归算法
     * @param node
     * @param e
     */
//    private void add(Node node, E e){
//        if(e.compareTo(node.e) < 0){
//            if(node.left == null) {
//                node.left = new Node(e);
//                size++;
//            }else {
//                add(node.left, e);
//            }
//        }else if(e.compareTo(node.e) > 0){
//            if(node.right ==null) {
//                node.right = new Node(e);
//                size++;
//            }else {
//                add(node.right, e);
//            }
//        }
//    }
    /**
     * 以node为根的二分搜索树传入E，递归算法
     * @param node
     * @param e
     */
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return  new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        } else {
            node.e = e;

        }

        // 更新height值
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor  = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){

        }
        /**
         * 当前node不平衡的原因在不平衡的结点的左侧的左侧, 调整使得成为AVL树
         */
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }


        /**
         * 插入的节点再不平衡节点的左侧的右侧
         * @param
         * @return
         */
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        /**
         * 插入的节点再不平衡节点的右侧的左侧
         * @param
         * @return
         */
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 右旋转 , 返回结点的height值, 插入结点在不平衡节点的左侧的左侧
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t = x.right;
        x.right = y;
        y.left = t;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 左旋转，插入结点在不平衡结点的右侧的右侧
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t = x.left;
        x.left = y;
        y.right = t;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }


    /**
     * 看二分搜索树是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node,E e){
        if(node == null) return  false;

        if(e.compareTo(node.e) < 0) return  contains(node.left, e);
        else if(e.compareTo(node.e) > 0) return contains(node.right, e);

        return true;
    }


    public void preOrder(){
        preorder(root );
    }
    /**
     * 前序遍历
     * @param node
     */
    public void preorder(Node node){
        if(node == null) return;
        System.out.println(node.e);
        preorder(node.left);
        preorder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private Stack<Node> stack = new Stack<>();
    /**
     * 前序遍历非递归
     * @return
     */
    private  void preOrderNoDiGui(){
        stack.push(root);

        while(!stack.isEmpty()){
            Node p = stack.pop();
            System.out.println(p.e);
            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
        }
    }
    /**
     * 中序遍历非递归
     * @return
     */
    public void inOrderNoRecursion(){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(!stack.isEmpty() || p != null){

            while(p != null){  // 走到最左边
                stack.push(p);
                 p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop(); // 去除最左边
                System.out.println(p.e);
                 p = p.right; // 是否有右子树，重复上述过程
            }
        }
    }
    /**
     *
     * 后序遍历非递归
     * @return
     */
    public void postOrderNoRecursion(){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node pre = null; // 保存上一个访问过的结点
        while(!stack.isEmpty() || p != null){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            Node cur = stack.pop();
            // 左右跟的顺序，如果上一个访问的节点是右子树节点，说明直接访问当前结点即可,把上一个结点置为当前结点
            if(cur.right == null || cur.right == pre){
                System.out.println(cur.e);
                pre = cur;
            }else {  // 没有访问过递归遍历右子树
                stack.push(cur);
                p = cur.right;
            }

        }
    }

    /**
     * 层序遍历, 广度优先遍历无权图彼岸准解法
     * @return
     */
    public void cengxu(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node q = queue.poll();
            System.out.println(q.e);
            if(q.left != null) queue.offer(q.left);
            if(q.right != null ) queue.offer(q.right);
        }
    }

    /**
     * 删除二分搜索树的最大值,返回这个最大值
     * @return
     */
    public E deleteNodeMax(){
        E maxmum = maxmum();
        deleteNodeMax(root);

        return maxmum;

    }

    /**
     * 删除以node为根的二分搜索树中的最小结点
     * 返回删除结点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node deleteNodeMax(Node node) {
        if(node == null){
            return  null;
        }

        if(node.right == null){
            Node leftNode = node.left;
//            node.left = null;
            size --;
            return leftNode;
        }

        node.right = deleteNodeMax(node.right);
        return node;
    }

    public E maxmum(){
        if(size == 0) return  null;
        return maxmum(root).e;
    }
    private Node maxmum(Node node) {
        if(node.right == null) return node;
        return maxmum(node.right);
    }


    /**
     * 删除二分搜索树的最小值
     * @return
     */
    public E deleteNodeMin(){
        E minimum = minimum();
        deleteNodeMin(root);

        return minimum;
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
    public E minimum(){
        if(size == 0) return  null;
        return minimum(root).e;
    }
    private Node minimum(Node node) {
        if(node.left == null) return node;
        return maxmum(node.left);
    }

    /**
     * 删除任意结点
     * @return
     */
    public void deleteAnyNode(E e){
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜素诺书中值为e的方法，递归算法
     * 返回删除节点后新的二分搜索树的根，并用res来维护平衡
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node == null) return null;
        Node res; // 用来维护修改之后的平衡
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            res =  node;
        }
        else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            res =  node;
        }
        else {

            if( node.left == null) { // 没有左孩子
                Node rightNode = node.right;
                node.right = null;
                size--;
                res =  rightNode;
            }
            else if(node.right == null){ // 没有右孩子
                Node leftNode = node.left;
                node.left = null;
                size--;
                res =  leftNode;
            }
            else{
                Node cur = minimum(node.right);
                // deleteMiN也需要维护平衡, 所以直接用remove，因为cur就是最小的节点
                cur.right = remove(node, cur.e); // 这里size不用减，因为找到的节点变成了当前子树的根节点,代替当前被删除的位置
                size++;
                cur.left = node.left;
                node.left = node.right =null; //删除node结点

                res =  cur;
            }




        }
        // 删除的是叶子结点的话
        if(res == null) return null;
        // 更新height值
        res.height = 1 + Math.max(getHeight(res.left), getHeight(res.right));

        int balanceFactor  = getBalanceFactor(res);
        if(Math.abs(balanceFactor) > 1){

        }
        /**
         * 当前node不平衡的原因在不平衡的结点的左侧的左侧, 调整使得成为AVL树
         */
        if(balanceFactor > 1 && getBalanceFactor(res.left) >= 0){
            return rightRotate(res);
        }
        if(balanceFactor < -1 && getBalanceFactor(res.right) <= 0){
            return leftRotate(res);
        }


        /**
         * 插入的节点再不平衡节点的左侧的右侧
         * @param
         * @return
         */
        if(balanceFactor > 1 && getBalanceFactor(res.left) < 0){
            res.left = leftRotate(res.left);
            return rightRotate(res);
        }
        /**
         * 插入的节点再不平衡节点的右侧的左侧
         * @param
         * @return
         */
        if(balanceFactor < -1 && getBalanceFactor(res.right) > 0){
            res.right = rightRotate(res.right);
            return leftRotate(res);
        }
        return  res;
    }

    /**
     * 实现数据的rank，数据不存在返回-1，存在返回rank值
     * @return
     */
    public int rank(E e){

        List<E> list = new LinkedList<>();

        rank(root, e, list);
        int res = 0;
        for (E value : list) {
            if (value.compareTo(e) == 0) return res;
        }
        return -1;
    }

    /**
     * 中序遍历是有序序列
     * @param node
     * @param e
     * @param list
     */
    private void rank(Node node, E e, List<E> list) {

        if(node == null )return;

        rank(node.left, e, list);
        list.add(node.e);
        rank(node.right, e, list);
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BinarySearchTree{ ");
        generateBSTString(root, 0 , stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder stringBuilder) {

        if(root == null) {
            stringBuilder.append(generateDepthString(depth) +"null \n");
            return;
        }
        stringBuilder.append(generateDepthString(depth) + root.e + "\n");
        generateBSTString(root.left, depth + 1, stringBuilder);
        generateBSTString(root.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth){
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        AVLTree<Integer> bst = new AVLTree<>();
        int [] nums = { 5, 3, 6 ,8, 4 ,2};

        for (int i = 0 ; i <  1000;i++) {
            bst.add(i);
        }
//        System.out.println(bst);
        System.out.println();
//        bst.inOrder();
        System.out.println(bst.deleteNodeMax());
        System.out.println(bst.deleteNodeMin());
//        System.out.println();
//        bst.postOrder();
        System.out.println();
//        bst.preOrderNoDiGui();
//        bst.inOrderNoRecursion();
//        bst.postOrderNoRecursion();
        System.out.println();
//        bst.cengxu();
    }
}
