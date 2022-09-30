package com.daily;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/25
 * Time: 15:41
 */
public class RotateNumber {
    public static boolean check(String s){
        int n = s.length();
        boolean valid = false;
        for(int i = 0 ; i < n;i++){
            int c = s.charAt(i) - '0';
            if(c == 3 || c == 7 || c == 4) return false;
            if(c == 2 || c == 5 || c == 6 || c == 9)  valid = true;

        }
        return valid;
    }
    public static void main(String[] args) {
        int n = 10;
        int res = 0;
        for(int i = 1 ; i <= n;i++){
            String s = Integer.toString(i);
            if(check(s)){
                res++;
            }
        }
        System.out.println(res);


    }
}
