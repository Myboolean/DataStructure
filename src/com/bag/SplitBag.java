package com.bag;

import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 14:48
 * 分组背包
 */
public class SplitBag {
    private static final int N = 1010;
    private static final int [] f = new int [N];

    private static final int [] v = new int [N];
    private static final int [] w = new int [N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        // 每次输入一堆v，w值，因为对于dp来说每一次都是用一组v，w值取更新，所以可以不用数组来接收
        for (int i = 1; i <= n ; i++) {
            String s1 = br.readLine();
            int x = Integer.parseInt(s1);
            for (int j = 0; j < x ; j++) {
                String[] s2 = br.readLine().split(" ");
                v[j] = Integer.parseInt(s2[0]);
                w[j] = Integer.parseInt(s2[1]);
            }
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < x; k++) {
                   if(j >= v[k]) f[j] =Math.max(f[j], f[j - v[k]] + w[k]);
                }
            }
        }
        System.out.println(f[m]);
        br.close();
        bw.close();

    }
}
