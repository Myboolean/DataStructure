package com.heap;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/6/24
 * Time: 16:49
 * 堆排序
 */
public class Main {
    private static final int N = 100010;
    private static int SIZE = 0;
    private static final int [] heap = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        SIZE = n;
        int m = Integer.parseInt(s1[1]);
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            heap[i] = Integer.parseInt(s[i-1]);
        }
        for (int i = n / 2; i >= 1 ; i--) {
            down(i);
        }
        for (int i = 1; i <= m; i++) {
            System.out.print(heap[1] + " ");
            heap[1] = heap[SIZE];
            SIZE--;
            down(1);
        }

    }
    public static void down(int position){
        int t = position;
        if(position * 2 <= SIZE && heap[t] > heap[position * 2]) t = position * 2;
        if(position * 2 + 1 <= SIZE && heap[t] > heap[position * 2 + 1]) t = position * 2 + 1;
        if(t != position){
            int temp = heap[t];
            heap[t] = heap[position];
            heap[position] = temp;
            down(t);
        }
    }
}
