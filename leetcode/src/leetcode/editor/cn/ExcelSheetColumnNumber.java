//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//... 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
//
// Related Topics 数学 字符串 👍 356 👎 0

 
package leetcode.editor.cn;
 
//Excel 表列序号
 
public class ExcelSheetColumnNumber{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new ExcelSheetColumnNumber().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        long [] arrays = new long[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = columnTitle.charAt(i) - 'A' + 1;
        }
        return count(arrays);
    }
    int count(long [] arrays){
        int n = arrays.length;
        long res = 0;
        int []p = new int[7];
        p[0] = 1;
        for (int i = 1; i < 7; i++) {
            p[i] = p[i - 1] * 26;
        }
        for (int i = n - 1; i >= 0; i--) {
            res += p[n - i - 1] * arrays[i];
        }
        return (int ) res ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}