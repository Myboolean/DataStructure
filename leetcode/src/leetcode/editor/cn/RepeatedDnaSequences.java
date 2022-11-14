//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 436 👎 0

 
package leetcode.editor.cn;
 
//重复的DNA序列

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatedDnaSequences{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new RepeatedDnaSequences().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int [] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;

                default: break;
            }
        }
        //记录重复出现的Hash值
        HashSet<Integer> seen  = new HashSet<>();
        // 记录重复出现的hash结果
        // 用来编码
        int L = 10;
        //进制数
        int R = 4;

        int RL = (int) Math.pow(R, L - 1);
        // 维护滑动窗口的hash值
        int windowHash = 0;
        HashSet<String> res  = new HashSet<>();
        int left = 0 , right = 0;
        while(right < nums.length) {
            windowHash = R * windowHash + nums[right];
            right++;

            if(right - left == L) {

                if(seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash = windowHash - RL * nums[left];
                left++;
            }
        }
        return new ArrayList<>(res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}