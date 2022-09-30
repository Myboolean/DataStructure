package com.jumpgame;

import learn.setandmap.map.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/27
 * Time: 17:08
 * 记忆化搜索
 */
public class JumpGame5 {
    int [] f = new int[100010];
    public void dfs(int [] arr ,int id, int d, int n){
        if(f[id] != 0) return ;
        f[id] = 1;

        for (int i = id - 1; i >= 0 && id - i <= d  && arr[id] > arr[i] ; i--) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
        for (int i = id + 1; i  < n && i - id <= d  && arr[id] > arr[i] ; i++) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        if(n == 1) return 1;
        int ans = 0;

        for(int i = 0 ; i < n;i++){
            dfs(arr, i, d, n);
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
