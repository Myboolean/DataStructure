package com.bingchaji;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/6/24
 * Time: 15:01
 */
import java.io.*;

public class Chain {

    private static final int N = 100010;
    private static final int[] p= new int[N];
    private static final int[] d = new int[N];
    private static int count = 0;
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
            int a = find(x);
            int b = find(y);
            if(x > n || y > n){
                count++;
            }else {
                if ("1".equals(s1[0])) {
                    if (a == b && (d[y] - d[x]) % 3 != 0) count++;
                    else if (a != b) {  //不在一棵树上但是也是同类,pa和pb之间的距离用来求是否为假话
                        p[a] = b;
                        d[a] = d[y] - d[x];
                    }
                } else {
                    if (a == b && (d[y] - d[x] + 1) % 3 != 0) count++;
                    else if (a != b) {
                        p[a] = b;
                        d[a] = d[y] - d[x] - 1;
                    }
                }
            }
            m--;
        }
        System.out.println(count);
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x){

        if(p[x] != x) {
            int a = find(p[x]);
            d[a] += d[p[x]];
            p[x] = a;
        }
        return p[x];
    }

}