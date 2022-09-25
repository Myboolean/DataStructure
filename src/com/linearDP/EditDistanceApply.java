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
public class EditDistanceApply {
    private static int N = 1010;
    private static int M = 20;
    private static int [][] dp = new int[M][M];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0].trim());
        int m = Integer.parseInt(s[1].trim());
        String[] x = new String[N];
        for (int i = 0; i < n; i++) {
            x[i] = br.readLine();
        }
        String r = null;
        for (int i = 0; i < m; i++) {
            int c = 0;
            String[] s1 = br.readLine().split(" ");
            r = s1[0];
            int max = Integer.parseInt(s1[1]);
            for (int j = 0; j < n; j++) {
                if(res(x[j], r,max)) c++;
            }
            System.out.println(c);
        }

    }
    public static boolean res(String a,String b,int max){
        int m = b.length();
        int n = a.length();
        for(int i = 0 ; i <= m;i++) dp[0][i] = i;
        for(int i = 0 ; i <= n;i++) dp[i][0] = i;


        for(int i = 1 ; i <= n;i++)
            for(int j = 1 ; j <= m; j++)
            {
                dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1);
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);
                else dp[i][j] = Math.min(dp[i-1][j-1] + 1,dp[i][j]);
            }
        if(dp[n][m] <= max) return true;
        return false;
    }
}
