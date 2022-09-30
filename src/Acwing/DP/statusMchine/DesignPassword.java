package Acwing.DP.statusMchine;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/29
 * Time: 18:48
 * m + 1个状态的状态机,需要kmp和自动机的知识
 */
public class DesignPassword {

    int [] ne = new int[60];
    final int N = (int) (1e9 +7);
    public boolean kmp(String s, String t){  // s和t的下标从1开始 ，O（N）时间复杂度
        int m = t.length() - 1;
        int n = s.length() - 1;
        for(int i = 2, j = 0; i <= m;i++){ // ne[1] = 0;
            while(j > 0 && t.charAt(i) != t.charAt(j + 1)) j = ne[j];
            if(t.charAt(i) == t.charAt(j + 1)) j++;
            ne[i] = j;
        }

        for(int i = 1 , j = 0 ; i <= n;i++){
            while (j > 0 && s.charAt(i) != t.charAt(j + 1)) j = ne[j];
            if(s.charAt(i) == t.charAt(j + 1)) j++;
            if(j == m){
                return true;
            }
        }

        return false;

    }

    public int designPassword(String s, String t){
        return 0;
    }
    public static void main(String[] args) {
        DesignPassword s = new DesignPassword();
        System.out.println(s.kmp(" "+"dadada", " daa"));
    }
}
