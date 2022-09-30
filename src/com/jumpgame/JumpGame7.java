package com.jumpgame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/27
 * Time: 18:40
 */
public class JumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean [] f = new boolean[n];
        f[0] = true;
        int cnt = 1; // i = 0可达，初始化为1
        for (int i = minJump; i < n; i++) {
            if(s.charAt(i) == '0' && cnt > 0){
                f[i] = true;
            }

            if(i >= maxJump && f[i - maxJump]) --cnt;
            if(f[i - minJump + 1]) ++cnt;
        }
        return f[n - 1];
    }
    public static void main(String[] args) {

    }
}
