package testjava.testtrywithresouces;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/10
 * Time: 16:45
 */
public class ReverseMtoN {
    Node successor = null;

    public Node reverseMtoN(Node head, int m, int n){
        if(m == 1) {
            return reverseNode(head, n);
        }
        head.next = reverseMtoN(head.next, m - 1, n - 1);
        return head;
    }

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
