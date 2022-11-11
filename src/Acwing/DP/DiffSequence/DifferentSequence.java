package Acwing.DP.DiffSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/14
 * Time: 14:05
 */
public class DifferentSequence {
    private static final int N = 2010;
    static long [][] f = new long[2][N];
    static final int MOD = (int) 1e9 + 7;

    static int distinctSubseqI(String s, String t){
        int n = s.length();
        int m = t.length();
        for (int i = 0; i <= n ; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= n ; i++) {

            for(int j = 1; j <= m;j++){
                f[i ][j] = f[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    f[i ][j] += f[i - 1 ][j - 1] % MOD;
                }
            }
        }

        return (int) f[n][m];
    }

    public static void main(String[] args) {
        System.out.println(distinctSubseqI("abbc", "abc"));
    }
}
