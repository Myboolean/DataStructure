package com.dfs;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/3
 * Time: 21:29
 */
public class NQueen {
    private static char [][] q ;
    private static boolean [][] s;
    private static int n;
    private static boolean [] col, dg,udg;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String x = br.readLine();
        n = Integer.parseInt(x);
        q = new char[n][n];
        udg = new boolean[n + 10];
        col = new boolean[n + 10];
        dg = new boolean[n + 10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q[i][j] = '.';
            }
        }
        s = new boolean[n][n];
        dfs(0);

    }

    public  static void dfs(int u) {
        if(u == n ){
            for(int i = 0;i <n;i++) {

                for (int j = 0; j < n; j++) {
                    System.out.print(q[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return ;
        }

        for(int i = 0 ; i < n;i++){
            if(!col[i] && !dg[i + u] && !udg[n - u + i]){
                col[i] = dg[i + u] = udg[n - u + i] = true;
                q[u][i] = 'Q';
                dfs(u + 1);
                col[i] = dg[i + u] = udg[n - u + i] = false;
                q[u][i] = '.';
            }
        }
    }
}
