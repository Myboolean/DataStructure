package testjava.testtrywithresouces;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/10
 * Time: 16:37
 */
class Node {
    int val;
    Node next;
    public Node() {

    }
    public Node(int val) {
        this.val = val;

    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
public class ReverseN {
    Node successor = null;
    public Node reverseNode(Node head, int n){
        if(n == 1) {
            successor = head.next;
            return head;
        }
        if(head == null || head.next == null) {
            return head;
        }
        Node last = reverseNode(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }
}
