package com.daily;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/20
 * Time: 12:37
 */
public class KthGrammer {

    public static int kthGrammar(int n, int k) {
        if(n < 2) return 0;
        int cnt = 0;
        while(k > 1){

            if(k > pow(2, n - 1)) {
                k -= pow(2, n - 1);
                cnt++;
            }
            if(k == 2) {
                k = 1;
                cnt++;
            }
            n--;
        }
        int ans = 0;
        for(int i = 0 ;  i < cnt;i++) ans = 1 - ans;
        return ans;

    }
    public static int pow(int x, int p){
        int c = x;
        while(p-- > 0) c *= x;
        return  c;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(3,4));
    }

}
