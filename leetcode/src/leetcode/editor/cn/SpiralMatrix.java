//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1259 👎 0

 
package leetcode.editor.cn;
 
//螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new SpiralMatrix().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int upper_bound = 0, right_bound = m - 1;
        int lower_bound = n - 1, left_bound = 0;
        List<Integer> res = new ArrayList<>();


        while (res.size() < m * n) {
            if(upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound ; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                upper_bound++;
                // 向下靠边界
            }

            if(left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound ; i++) {
                    res.add(matrix[i][right_bound]);

                }
                right_bound--;
                // 收缩右边界
            }
            if(upper_bound <= lower_bound) {
                for (int i = right_bound; i >= left_bound ; i--) {
                    res.add(matrix[lower_bound][i]);
                }
                lower_bound--;
                //收缩下边界
            }

            if(left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound ; i--) {
                    res.add(matrix[i][left_bound]);

                }
                left_bound++;
                // 收缩右边界
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}