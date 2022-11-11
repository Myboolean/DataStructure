//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 525 👎 0

 
package leetcode.editor.cn;
 
//子数组的最小值之和

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubarrayMinimums{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new SumOfSubarrayMinimums().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int MOD = (int)1e9+7;
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] l = new int[n], r = new int[n];
            Arrays.fill(l, -1); Arrays.fill(r, n);
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!d.isEmpty() && arr[d.peekLast()] >= arr[i]) r[d.pollLast()] = i;
                d.addLast(i);
            }
            d.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!d.isEmpty() && arr[d.peekLast()] > arr[i]) l[d.pollLast()] = i;
                d.addLast(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int a = l[i], b = r[i];
                ans += (i - a) * 1L * (b - i) % MOD * arr[i] % MOD;
                ans %= MOD;
            }
            return (int) ans;
        }



}
//leetcode submit region end(Prohibit modification and deletion)

}