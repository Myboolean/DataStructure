//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 859 👎 0

 
package leetcode.editor.cn;
 
//螺旋矩阵 II
 
public class SpiralMatrixIi{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new SpiralMatrixIi().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int upper_bound = 0 , right_bound = n - 1;
        int left_bound = 0, lower_bound = n - 1;
        int  count = 1 ;
        while(count < n * n) {
            if(upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound ; i++) {
                    res[upper_bound][i] = count++;
                }
                upper_bound++;
            }

            if(left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound ; i++) {
                    res[i][right_bound] = count++;
                }
                right_bound--;
            }

            if(upper_bound <= lower_bound) {
                for (int i = right_bound; i >= left_bound ; i--) {
                    res[lower_bound][i] = count++;
                }
                lower_bound--;
            }

            if(left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound ; i--) {
                    res[i][left_bound] = count++;
                }
                left_bound++;
            }

        }
        if(n % 2 == 1) {
            res[n/ 2][n / 2] = n * n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}