package com.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/2
 * Time: 18:54
 */
public class LRChange {
    static int []f = new int [6];
    public static boolean canTransform(String start, String end) {
        int n = start.length(), m = end.length();
        if(n != m) return false;
        for (int i = 0; i < n; i++) {
            if(start.charAt(i) == end.charAt(i) ){
                if(start.charAt(i) == 'X') {

                    f[0]++;
                    f[3]++;
                }else if(start.charAt(i) == 'L') {
                    f[1]++;
                    f[4]++;
                }else {
                    f[2]++;
                    f[5]++;
                }

            }else {
                char a = start.charAt(i), b = end.charAt(i);

            }
        }
        return false;

    }
    public static void main(String[] args) {

    }
}
