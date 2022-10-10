package Acwing.HighLevelDataStructure.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/9
 * Time: 11:46
 * 枚举的思想
 * x + n
 *  x为奇数
 *      x y同类
 *          x是奇数那么y也是奇数
 *      x y不同类
 *          x是奇数那么y是偶数
 */
public class EnumOddEvenGame {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static final int N = 20010 * 2;
    static int n, m;
    static int [] p =new int[N];
    private static int get(int t){
        if(!map.containsKey(t)){
            map.put(t, ++n);
        }
        return map.get(t);
    }
    private static int find(int t){
        if(p[t] != t) {
            p[t] = find(p[t]);
        }
        return p[t];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        String[] s2 = br.readLine().split(" ");
        m = Integer.parseInt(s2[0]);
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        n = 0;
        int res = m;
        for (int i = 0; i < m; i++) {
            int a, b;
            String[] s1 = br.readLine().split(" ");

            a = Integer.parseInt(s1[0]);
            b = Integer.parseInt(s1[1]);
            a = get(a - 1);
            b = get(b);
            if(s1[2].equals("even")){
                if (find(a + n) == find(b)) {
                    res = i;
                    break;
                }
                p[find(a)] = find(b);
                p[find(a + n)] = find(b + n);
            }else {
                if(find(a) == find(b)) {
                    res = i - 1;
                    break;
                }
                p[find(a+n)] = p[find(b)];
                p[find(a)] = p[find(b+n)];
            }
        }

        System.out.println(res);
    }
}
