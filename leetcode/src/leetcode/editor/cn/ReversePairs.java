//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 383 👎 0

 
package leetcode.editor.cn;
 
//翻转对

import java.util.ArrayList;
import java.util.List;

public class ReversePairs{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new ReversePairs().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private  int count ;
    int [] temp;
    public int reversePairs(int[] nums) {

        temp = new int[nums.length];

        sort(nums, 0, nums.length - 1);

        return count;
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

        while(i <= mid ){
            // 当前位大于后面的 nums[j] * 2 >> j 后移 数量加 1
            while(j <= r && (long)nums[i] > (long)nums[j] * 2){
                j++;
            }
            // 结果
            count += j - (mid + 1);
            // 下一个
            i++;
        }
        i = l;
        j = mid + 1;
        while(i <= mid && j <= r) {
            if(nums[i] > nums [j]) {
                // 在这里算会重复计算，有可能i会大于好几个j
                temp[k++] = nums[j++];
            } else {

                temp[k++] = nums[i++];
            }
        }

        while(i <= mid) {

            temp[k++] = nums[i++];
        }
        while(j <= r) {
            temp[k++] = nums[j++];
        }
        for (int m = l, d = l; m <= r ; m++) {
            nums[m] = temp[d++];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}