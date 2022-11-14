//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 👍 753 👎 0

 
package leetcode.editor.cn;
 
//分割数组的最大值

import java.util.Arrays;

public class SplitArrayLargestSum{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new SplitArrayLargestSum().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (verify(nums, k, mid)) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean verify(int [] nums, int k, int H) {
        int count = 1;
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single += nums[i];
            if (single > H){
                count++;
                single = nums[i];
            }
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}