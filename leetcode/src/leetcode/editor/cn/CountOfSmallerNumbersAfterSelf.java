//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 911 👎 0

 
package leetcode.editor.cn;
 
//计算右侧小于当前元素的个数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();

     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<Integer> res;
    int [] index;
    private int[] count ;
    int [] temp;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        index = new int[nums.length];
        temp = new int[nums.length];
        res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }
    public void sort(int [] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;

        sort(nums, l, mid );
        sort(nums, mid + 1, r);
        merge(nums, l, mid ,r );
    }

    private void merge(int[] nums, int l, int mid, int r) {

        int i = l , j  = mid + 1;
        int k = l;
        if(nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }
        while(i <= mid && j <= r) {
            if(nums[index[i]] > nums [index[j]]) {
                // 在这里算会重复计算，有可能i会大于好几个j
                temp[k++] = index[j++];
            } else {
                count[index[i]] += j - mid - 1;
                temp[k++] = index[i++];
            }
        }
        while(i <= mid) {
            count[index[i]] += j - mid - 1;
            temp[k++] = index[i++];
        }
        while(j <= r) {
            temp[k++] = index[j++];
        }
        for (int m = l, d = l; m <= r ; m++) {
            index[m] = temp[d++];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}