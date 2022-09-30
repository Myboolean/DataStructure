package com.jumpgame;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/27
 * Time: 15:12
 */
public class JumpGame3 {
    static boolean []visited = new boolean[100010];
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(n < 1) return false;
        if(arr[start] == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[arr[start]] = true;
        while(!q.isEmpty()){
            Integer b = q.poll();
            System.out.println(b);
            if(b < n && b >= 0 && arr[b] == 0) return true;
            if(b >= n || b < 0) continue;
            if(b + arr[b] >= 0 && !visited[b + arr[b]] ) {
                q.offer(b + arr[b]);
                visited[b + arr[b]] = true;
            }
            if(b - arr[b] >= 0 && !visited[b - arr[b]]){
                q.offer(b - arr[b]);
                visited[b - arr[b]] = true;
            }
        }
        return  false;
    }
    boolean dfs(int [] arr , int start){
        if(start >= arr.length || start < 0 ) return false;
        if(arr[start] == 0) return  true;
        if(visited[start]) return false;
        else visited[start] = true;
        return  dfs(arr, start + arr[start])||  dfs(arr, start - arr[start]);
    }
    public static void main(String[] args) {

        int [] nums = new int [] {0,3,0,6,3,3,4};
        System.out.println(canReach(nums, 6));
    }
}
