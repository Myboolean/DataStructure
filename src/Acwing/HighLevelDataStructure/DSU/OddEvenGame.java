package Acwing.HighLevelDataStructure.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/8
 * Time: 20:44
 * 并查集必须要有传递性和图的边是无向的，也就是对称性
 * 1.带边权的并查集怎么做
 *      1.每个点跟根节点的关系
 *      2.d[x] 表示x和p[x]的关系
 *          0表示同类
 *          1表示不同类
 *          dx + dy是奇数的话表示 dx和dy不同类
 *          dx + dy是偶数表示 dx和dy是相同类
 *              px == py说明x和y在同一个集合里面
 *              判断 dx ^ dy
 *                  为0 无矛盾
 *                  为1 有矛盾
 *              px != py
 *                  p[x] = p[y]
 *                  dx + ? + dy == 0
 *                  ? = (偶 - dx - dy +2 ) % 2  在 模2的情况下取值才有意义
 *                  等价于  ? = dpx = dx ^ dy
 *        不同类
 *              px == py
 *                  判断dx ^ dy
 *                      0有矛盾
 *                      1 无矛盾
 *              px != py
 *                  ? = (奇- dx - dy +2 ) % 2
 *                  dpx = dx ^ dy ^ 1
 *              加法在摸2意义下是等于异或的
 *
 */
public class OddEvenGame {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static final int N = 20010;
    static int n, m;
    static int [] p =new int[N];
    static int [] d = new int[N];
    private static int get(int t){
        if(!map.containsKey(t)){
            map.put(t, ++n);
        }
        return map.get(t);
    }
    private static int find(int t){
        if(p[t] != t) {
            int root = find(p[t]);
            d[t] ^= d[p[t]];
            p[t] = root;
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
            int t = 0;
            if(s1[2].equals("odd")) t = 1;
            int pa = find(a), pb = find(b);
            if(pa == pb){
                if((d[a] ^ d[b]) != t) {
                    res = i;
                    break;
                }
            }else {
                p[pa] = pb;
                d[pa] = d[a] ^ d[b] ^ t;
            }
        }
        System.out.println(res);

    }
}
