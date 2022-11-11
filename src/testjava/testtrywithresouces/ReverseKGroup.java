package testjava.testtrywithresouces;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/10
 * Time: 19:13
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode rever = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return rever;
    }
    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null, cur = a, next = a;

        while(cur != b){
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}