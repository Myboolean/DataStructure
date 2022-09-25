package com.heap;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/6/27
 * Time: 16:47
 */
public class MockHeap {

    private static final int N = 100010;
    private static int SIZE = 0;
    private static final int [] h = new int[N];
    private static final int[] ph = new int[N];   //存放第K个插入点的下标
    private static final int[] hp = new int[N];  // 存放堆中点的插入次序
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        SIZE = n;

        String[] s = null;
        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            if("I".equals(s[0])){
                int x = Integer.parseInt(s[1]);
                down(i);
            }else if("PM".equals(s[0])){

            }else if("DM".equals(s[0])){

            }else if("D".equals(s[0])){

            }else if("C".equals(s[0])){

            }
        }
        for (int i = n / 2; i >= 1 ; i--) {
            down(i);
        }


    }
    public static void down(int position){
        int t = position;
        if(position * 2 <= SIZE && h[t] > h[position * 2]) t = position * 2;
        if(position * 2 + 1 <= SIZE && h[t] > h[position * 2 + 1]) t = position * 2 + 1;
        if(t != position){
            int temp = h[t];
            h[t] = h[position];
            h[position] = temp;
            down(t);
        }
    }
//    public static void heapSwap(int u, int v){
//        swap(h,u,v);
//        swap(hp, u, v);
//        swap(ph, hp[u], hp[v]);
//    }
//    public static void swap(int u, int v){
//        int temp = h[u];
//        h[u] = h[v];
//        h[v] = temp;
//    }
}
