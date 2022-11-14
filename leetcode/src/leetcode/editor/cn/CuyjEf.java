//给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 
//i 的概率与 w[i] 成正比。 
//
// 
// 
//
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
//
// 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//inputs = ["Solution","pickIndex"]
//inputs = [[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 
//输入：
//inputs = ["Solution","pickIndex","pickIndex","pickIndex","pickIndex",
//"pickIndex"]
//inputs = [[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 10000 
// 1 <= w[i] <= 10^5 
// pickIndex 将被调用不超过 10000 次 
// 
//
// 
//
// 
// 注意：本题与主站 528 题相同： https://leetcode-cn.com/problems/random-pick-with-weight/ 
//
// Related Topics 数学 二分查找 前缀和 随机化 👍 36 👎 0

 
package leetcode.editor.cn;
 
//按权重生成随机数

import java.util.Random;

public class CuyjEf{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new CuyjEf().new Solution(new int[]{1});
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Random rand = new Random();
    int [] s;
    int n;
    public Solution(int[] w) {
        n = w.length;
        s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int target = rand.nextInt(s[n]) + 1;
        return rightBound(target) - 1;
    }
    public int rightBound(int t) {
        int l = 0 ,r = n;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(s[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}