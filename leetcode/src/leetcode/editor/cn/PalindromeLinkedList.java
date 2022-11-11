//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1564 👎 0

 
package leetcode.editor.cn;
 
//回文链表
 
public class PalindromeLinkedList{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new PalindromeLinkedList().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
//    public boolean isPalindrome(ListNode head){
//        ListNode fast = head, slow = head;
//        while(fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        // 奇数的时候不会走到链表null的位置，需要再进一步
//        if(fast != null) {
//            slow = slow.next;
//        }
//
//        ListNode res = reverse(slow);
//        while (res != null){
//            if(res.val != head.val) {
//                return false;
//            }
//            res = res.next;
//            head = head.next;
//        }
//
//        return true;
//
//    }
//    public ListNode reverse(ListNode head){
//        if(head  == null || head.next == null) {
//            return head;
//        }
//        ListNode last = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }
    //解法2
//    ListNode left;
//
//    boolean isPalindrome(ListNode head) {
//        left = head;
//        return traverse(head);
//    }
//
//    boolean traverse(ListNode right) {
//        if (right == null) return true;
//        boolean res = traverse(right.next);
//        // 后序遍历代码
//        res = res && (right.val == left.val);
//        left = left.next;
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}