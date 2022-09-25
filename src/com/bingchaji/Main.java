package com.bingchaji;

import java.io.*;

public class Main {

    private static final int N = 100010;
    private static final int[] p= new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        System.out.println();
        int m = Integer.parseInt(s[1]);
        while(m>0){
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[1]);
            int y = Integer.parseInt(s1[2]);
            if("M".equals(s1[0])){
                if(find(x) != find(y)) p[x] = y;
            }else {
                if(find(x) != find(y)) System.out.println("No");
                else System.out.println("Yes");
            }
            m--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

}
