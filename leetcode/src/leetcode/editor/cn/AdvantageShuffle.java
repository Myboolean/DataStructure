//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 343 👎 0

 
package leetcode.editor.cn;
 
//优势洗牌

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AdvantageShuffle{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new AdvantageShuffle().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int [] res = new int [nums1.length];
        PriorityQueue<int []> maxPQ = new PriorityQueue<>(nums2.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums2.length; i++){
            maxPQ.offer(new int[] {i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;

        while(!maxPQ.isEmpty()) {
            int[] poll = maxPQ.poll();
            int i = poll[0], maxVal = poll[1];
            if(nums1[right] > maxVal) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}