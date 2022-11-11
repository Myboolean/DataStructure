package Acwing.DP.shuweiDP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/18
 * Time: 14:57
 */
public class QuestionCount {

    /**
     * 求10的xcifang
     * @param x
     * @return
     */
    static int power10(int x)
    {
        int res = 1;
        while(x-- > 0)
            res *= 10;
        return res;
    }

    /**
     * 用于求前面0 ~ abc的种方案。
     * @param num
     * @param l
     * @param r
     * @return
     */
    static int sum(List<Integer> num, int l ,int r)
    {
        int res = 0;
        for(int i = l; i>=r; i--)
            res = res * 10 ;
        return res;
    }
    /**
     * 1到n中统计x出现的次数
     * @param n
     * @param x
     * @return
     */
    static int count(int n, int x) {
        if(n == 0) return 0;
        List<Integer> num = new ArrayList<>();
        while(n > 0){
            num.add(n % 10);
            n /=10;
        }

        n = num.size();
//        int res = 0;
//        for (int i = n - 1 -(x == 0 ? 1: 0); i >= 0 ; i--) {
//            if(i < n -1)
//            {
//                res += get(num,n -1, i+1)*power10(i);
//                if(!x) res -= power10(i);
//            }
//            if(num[i] == x) res += get(i -1,0) + 1;
//            else if(num[i] > x) res += power10(i);
//        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
