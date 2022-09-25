package com.qujianhe;

import java.util.*;
public class Demo{
    private static int N = 100010;
    private static int [] a = new int[N];
    private static int [] s = new int[N];
    private static List<Integer> alls = new ArrayList<Integer>();
    private static Map<Integer,Integer> add = new HashMap<Integer, Integer>();
    private static Map<Integer,Integer> query = new HashMap<Integer, Integer>();
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 0 ; i < n;i++){
            int l = scanner.nextInt();
            int c = scanner.nextInt();
            alls.add(l);
            add.put(l,c);
        }

        for(int i = 0 ; i < n;i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            query.put(l,r);
            alls.add(l);
            alls.add(r);
        }
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(alls);
        alls = new ArrayList<>(hashSet);
        alls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Set<Integer> integers = add.keySet();
        //获取每一个键和值，获取在数组中对应的位置并且加和
        for (Integer x: integers) {
            int y = add.get(x);
//            System.out.println(y);
            int position = find(alls, x);
//            System.out.println(position);
            a[position] += y;
        }
//        System.out.println(add.size());
        // 这里应该是alls.size()代表有多少个坐标
//        for (int i = 1; i <= alls.size() ; i++) {
//            System.out.print(a[i] +" ");
//        }
        System.out.println();
        Set<Integer> querys = query.keySet();
        for(int i = 1 ; i <= alls.size();i++){
            s[i] = s[i-1] + a[i];
        }
//        for (int i = 1; i <= alls.size() ; i++) {
//            System.out.print(s[i] +" ");
//        }
        for (Integer x:
             querys) {
            int y = query.get(x);
            int l = find(alls, x);
            int r = find(alls, y);
            System.out.println(s[r] - s[l-1]);
        }
    }
    public static int find(List<Integer> a, int x){
        int l = 0,r = a.size() - 1;
        while(l < r){
            int mid = l + r + 1>> 1;
            if(a.get(mid) <= x) l = mid;
            else r = mid - 1;
        }
        return l + 1;
    }


}