package com.qujianDP;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/11
 * Time: 6:52
 */
public class MergeStone {
    private static int N = 1010;

    private static int [][] dp = new int[N][N];
    private static int[] a = new int[N];
    private static int[] x = new int[N];
    /**
     * f[i][j] 表示所有将[i,j]这一段合并成一堆的集合
     *          属性:min
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 1; i <= n ; i++) {
            x[i] = x[i-1] + a[i-1];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1  <= n ; i++) {
                //  划分方法
                int j = i + len - 1;
                dp[i][j] = (int) 1e8; // 取最小值需要置为很大的值
                //区间划分i ~ j - 1
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + x[j] - x[i-1]);
                }

            }
        }
        System.out.println(dp[1][n]);

    }
}
