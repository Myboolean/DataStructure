package Acwing.DP.DiffSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/14
 * Time: 14:05
 */
public class DifferentSequenceTwo {
    static int [] f = new int[26];
    static final int MOD = (int) 1e9 + 7;

    static int distinctSubseqII(String s){
        int n = s.length();
        int ans = 0;
        /**
         * 在第1次遍历到字符‘b’的时候：子序列为“ab”、“b”；
         * 在第2次遍历到字符‘b’的时候：子序列为“ab”、“b”、“abb”、“bb”、“acb”、“abcb”、“bcb”、“cb”；
         * 【结论】我们发现第2次遍历字符'b'的时候，已经包含了第1次遍历字符'b'的子序列了。所以，在统计最终结果的时候，我们需要把“上一次”相同字符子序列总数减去才可以。
         *
         */
        for (int i = 0; i < n ; i++) {
            int c = s.charAt(i) - 'a';
            int prev = f[c]; // 上一次统计字符c的子序列数
            f[c] = (ans + 1) % MOD;  // 1是当前字符本身
            ans = (ans + f[c] - prev + MOD) % MOD;


        }
        return ans;

    }

    /***
     * DP解决
     * @param s
     * @return
     */
    static int [][] d = new int [2010][26];
    static int distinctSubseqIIDP(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 1 ; i <= n;i++){
            int c = s.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                if(c == j){
                    int cur = 1;
                    for (int k = 0; k < 26; k++) cur = (cur + d[i - 1][k]) % MOD;
                    d[i][j] = cur;
                }else d[i][j] = d[i - 1][j];
            }
        }

        for (int i = 0; i < 26; i++) {
            ans = (ans + d[n][i]) %MOD;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("abc"));
    }
}
