package com.linearDP;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 18:58
 * f [i][j] 集合  所有A[1-i]与B[1-j]的公共子序列的集合
 *          属性 max
 *
 *          最后一个不确定的状态就是A[i]  B[j]可以分为00 01 10 11   0,1分别表示是否包含
 *          if(a]i]==b[j]) f[i-1, j -1] + 1  11
 *                         f[i-1, j -1]      00
 *                         f[i-1,j]    01  为什么可以用，因为不是求数量，求max和min的时候集合是可以重复的，不影响最大最小值的值
 */
public class LongestCommonSeries {
    private static int N = 1010;

    private static int [][] dp = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String a = br.readLine();
        String b = br.readLine();
        for(int i = 1 ; i <= n;i++)
            for(int j = 1 ; j <= m; j++)
            {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
            }
        System.out.println(dp[n][m]);

    }
}
