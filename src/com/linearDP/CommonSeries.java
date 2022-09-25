package com.linearDP;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 17:31
 */
public class CommonSeries {
    private static int N = 1010;
    private static int [] f = new int[N];
    private static int [] dp = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n ; i++) {
            f[i] = Integer.parseInt(s1[i - 1]);
        }
        dp[1] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j < i ; j++) {
                if(f[i] > f[j]) dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            dp[i] = Math.max(dp[i],1);// 倒数第二个数不存在，即只有一个数
        }
        System.out.println(dp[n]);
    }

}
