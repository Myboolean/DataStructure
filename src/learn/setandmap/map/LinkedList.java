package learn.setandmap.map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/20
 * Time: 14:24
 */
public class LinkedList<E> {

    class Node{
        E val;
        Node next;

        public Node(E val, Node next){
            Node node = new Node(val, next);
        }
        public Node(E val){
            this(val, null);
        }

    }

    private Node dummyHead;
    private int size;
    public boolean isEmpty() { return size == 0 ;}
    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int size(){
        return size;
    }
    // 在链表头添加新的元素e
//    public E addFirst(E e){
////        Node node = new Node(e);
////        node.next = head;
////        head = node;
//        try{
//        head = new Node(e, head);
//        size ++;
//        } catch (Exception exception){
//            return null;
//        }
//        return head.val;
//    }
    public E add(int index, E e){
        if(index < 0 || index >= size) return null;


        Node prev = dummyHead;
        for(int i = 0 ; i < index;i++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size ++;

        return e;
    }
        public E addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        try{
            add(0,e);
        } catch (Exception exception){
            return null;
        }
        return e;
    }
    public E addLast(E e){
        return add(size, e);
    }

    public E get(int index){
        if(index < 0 || index >= size) return null;
        Node prev = dummyHead.next;
        for(int i = 0 ; i < index;i++)
            prev = prev.next;
        return  prev.val;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.val = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.val.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.val;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur).append("->");
        res.append("NULL");

        return res.toString();
    }
}
