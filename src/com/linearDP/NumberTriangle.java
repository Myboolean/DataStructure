package com.linearDP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 15:42
 * dp[i][j] 所有从起点走到i，j的路径
 * 属性：集合当中所有路径之和的最大值
 */
public class NumberTriangle {
    private static final int N = 510;
    private static final int [][]f = new int[N][N];
    private static int [][] dp = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                f[i][j] = Integer.parseInt(s1[j-1]);
            }
        }
/**
 * 初始化除了初始位置的其他位置为负无穷，因为必须要保证从1,1的位置开始
 */
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[1][1] = f[1][1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] ) +f[i][j];
            }
        }

        // 每次输入一堆v，w值，因为对于dp来说每一次都是用一组v，w值取更新，所以可以不用数组来接收
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            res = Math.max(res,dp[n][i]);
        }
        System.out.println(res);
        br.close();
        bw.close();

    }

}
class Index{
    private int x;
    private int y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
