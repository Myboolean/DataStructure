package com.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/4
 * Time: 17:45
 */
public class RunWithTown {
    private static int[][] g;
    private static int n;
    private static int m;
    private static int[] dx=new int[]{-1,0,1,0};
    private static int[] dy=new int[]{0,1,0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        g = new int[n + 1][m + 1];
        // 读取数据
        for (int j = 1; j <= n; j++) {
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < s1.length; i++) {
                g[j][i + 1] = Integer.parseInt(s1[i]);
            }
        }

    }

    public static void bfs() {
        Map<Integer,Integer> p = new HashMap<>();
        p.put(1,1);

    }
}
