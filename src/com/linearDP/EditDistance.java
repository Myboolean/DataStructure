package com.linearDP;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 19:43
 * f[i][j] 表示A从1-i变成B从1-j的操作方式
 *          属性是  min取最小操作次数
 *
 *    集合划分
 *    如果是删，那么A1-i-1与B1-j匹配，那么是f[i][j]和f[i-1][j]+1取小的值
 *    如果是增，那么A1-i与B1-j-1匹配，那么是f[i][j]和f[i][j-1]+1取小的值
 *    如果a[i] = b[j]那么和f[i-1][j-1]比大小即可，不相等则改
 */
public class EditDistance {
    private static int N = 1010;

    private static int [][] dp = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = Integer.parseInt(s.trim());

        String a = br.readLine();
        String s1 = br.readLine();
        int m = Integer.parseInt(s1.trim());
        String b = br.readLine();
        for(int i = 1 ; i <= n;i++)
            for(int j = 1 ; j <= m; j++) {
                dp[i][j] = (int)1e9;
            }

        for(int i = 1 ; i <= n;i++)
            for(int j = 1 ; j <= m; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1] + 1,dp[i][j]);
                dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j]);
                dp[i][j] = Math.min(dp[i][j-1] + 1,dp[i][j]);

            }
        System.out.println(dp[n][m]);

    }
}
