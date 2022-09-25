package com.dfs;

import java.io.*;


/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/3
 * Time: 17:19
 */
public class PaiLie {
    private static final int [] path = new int[10];
    private static final boolean [] s = new boolean[10];
    private static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        n = Integer.parseInt(s);

        dfs(0);

    }

    public  static void dfs(int u){
        if(u == n){
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1 ;  i <=n  ;i++){
            if(!s[i]){
                path[u] = i;
                s[i] = true;
                dfs(u +  1);
                s[i] = false;
                path[u] = 0;
            }
        }
    }

}
