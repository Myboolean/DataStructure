package com.countDp;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/11
 * Time: 7:20
 */

/**
 * 整数划分，要求递减但划分其实不考虑顺序性
 * 一个正整数 n 可以表示成若干个正整数之和，形如：n=n1+n2+…+nk，其中 n1≥n2≥…≥nk,k≥1。
 *
 * 我们将这样的一种表示称为正整数 n 的一种划分。
 *
 * 现在给定一个正整数 n，请你求出 n 共有多少种不同的划分方法。
 */

import java.io.*;

/**
 * 解法，可以看成容量是n的物品，物品的体积分别为1-n的完全背包问题
 * 跟对最后一个物品选了多少个来划分
 * 背包什么时候逆序，需要不能用这一次的体积更新
 */
public class SplitNum {
    /**
     * 单调队列优化方法
     * 1000 20000 20000
     * @param args
     * @throws IOException
     */
    private static final int N = 1010;
    private static final int M = (int) 1e9;
    private static final int [] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        f[0] = 1;// 什么都不选种类为一种,体积为0，方法数应该是一种

        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                //因为f[j]一定是上一个状态的
                f[j] = (f[j] + f[j - i]) % M;
            }
        }

        System.out.println(f[n]);
        br.close();
        bw.close();

    }
}
