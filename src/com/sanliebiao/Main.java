package com.sanliebiao;

import java.io.*;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/6/28
 * Time: 15:50
 */
public class Main {
//    private static final int N = 100003;//散列不容易冲突
    private static final int N = 200003;//散列不容易冲突
    private static int flag = 0x3f3f3f3f;
    private static final int [] h = new int[N];
//    private static final int [] e = new int[N];
//    private static final int [] ne = new int[N];
    // 拉链法
//    public static void main(String[] args) throws IOException {
//        Arrays.fill(h, -1);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] s = br.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        while(n-->0){
//            String[] s1 = br.readLine().split(" ");
//            if("I".equals(s1[0])){
//                insert(Integer.parseInt(s1[1]));
//            }else{
//                boolean flag = find(Integer.parseInt(s1[1]));
//                if(flag) System.out.println("Yes");
//                else System.out.println("No");
//            }
//        }
//        br.close();
//        bw.close();
//    }
//    public static void insert(int x){
//        int k = (x % N + N) % N;
//        e[idx] = x;
//        ne[idx] = h[k];
//        h[k] = idx++;
//    }
//    public static boolean find(int x){
//        int k = (x % N + N) % N;
//        for(int i = h[k] ; i != -1;i = ne[i]){
//            int j = e[i];
//            if(x == j) return true;
//        }
//        return false;
//    }
    public static int find(int x){
        int k = (x % N + N) % N;
        while(h[k] != 0x3f3f3f3f && h[k] != x){
            k++;
            if(k == N) k = 0;
        }
        return k;
    }
    public static void main(String[] args) throws IOException {
        Arrays.fill(h, flag);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        while(n-->0){
            String[] s1 = br.readLine().split(" ");
            int t = find(Integer.parseInt(s1[1]));
            if("I".equals(s1[0])){

                h[t] = t;

            }else{
                if(h[t] != flag) System.out.println("Yes");
                else System.out.println("No");

            }
        }
    }

}
