package com.liusanhua;

import java.util.*;

public class Main {
    private static int count;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = scanner.nextInt();
        int st = -1000000;
        int ed = -1000000;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            map.put(x,y);
        }
        Set<Integer> integers = map.keySet();
        for (Integer x:
             integers) {
            int y = map.get(x);
            if(ed < x){
                if(st!=-1000000)count++;
                st = x;
                ed = y;
            }else{
                ed = Math.max(ed, y);
            }
        }
        if(st != -1000000) count++;
        System.out.println(count);
    }
}
