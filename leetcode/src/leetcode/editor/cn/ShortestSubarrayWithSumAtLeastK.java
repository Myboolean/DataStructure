//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 480 👎 0

 
package leetcode.editor.cn;
 
//和至少为 K 的最短子数组

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static final int N = 100010;
    public long [] sum = new long [N];
    int n;
    public int shortestSubarray(int[] nums, int k) {
        n = nums.length;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if(nums[i - 1]  >= k) return 1;
         }
        int res = Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <= n  ; i++) {

            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i]) q.pollLast();

            while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k) {

                res = Math.min(res, i - q.pollFirst());
            }
            q.addLast(i);



        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}