package com.jumpgame;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/27
 * Time: 16:38
 */
public class JumpGame4 {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if( n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) { //computeIfAbsent   此方法首先判断缓存MAP中是否存在指定key的值，
            // 如果不存在，会自动调用mappingFunction(key)计算key的value，然后将key =
            // value放入到缓存Map,java8会使用thread-safe的方式从cache中存取记录。
            map.computeIfAbsent(arr[i], v-> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean [] visitied = new boolean[n];
        q.offer(0);
        visitied[0] = true;
        int ans  =  0;
        while(!q.isEmpty()){
            //
            int size = q.size();
            while(size -- > 0){
                int index = q.poll();

                if(index == n -1) return ans;

                // 相邻的边入队
                if(map.containsKey(arr[index]))
                    for(int next: map.get(arr[index])){
                        if(next != index && !visitied[next]){
                            q.offer(next);
                            visitied[next] = true;
                        }
                        // 剪枝，和这个元素相邻的边都处理过了，再遍历肯定访问过，不如直接移除
                        map.remove(arr[index]);
                    }

                if(index + 1 < n && !visitied[index + 1]){
                    q.offer(index + 1);
                    visitied[index + 1]  = true;

                }
                if(index - 1 >= 0 && !visitied[index - 1]){
                    q.offer(index - 1);
                    visitied[index - 1]  = true;

                }
            }
            ans ++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] a = new int [] {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(a));
    }
}
