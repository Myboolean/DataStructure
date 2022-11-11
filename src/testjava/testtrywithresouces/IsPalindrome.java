package testjava.testtrywithresouces;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/10
 * Time: 19:39
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数的时候不会走到链表null的位置，需要再进一步
        if(fast != null) {
            slow = slow.next;
        }

        ListNode res = reverse(slow);
        while (res != null){
            if(res.val != head.val) {
                return false;
            }
            res = res.next;
            head = head.next;
        }

        return true;

    }
    public ListNode reverse(ListNode head){
        if(head  == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
