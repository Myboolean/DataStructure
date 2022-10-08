package Acwing.HighLevelDataStructure.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/30
 * Time: 10:09
 * Joe觉得云朵很美，决定去山上的商店买一些云朵。
 *
 * 商店里有 n 朵云，云朵被编号为 1,2,…,n，并且每朵云都有一个价值。
 *
 * 但是商店老板跟他说，一些云朵要搭配来买才好，所以买一朵云则与这朵云有搭配的云都要买。
 *
 * 但是Joe的钱有限，所以他希望买的价值越多越好。
 *
 * 输入格式
 * 第 1 行包含三个整数 n，m，w，表示有 n 朵云，m 个搭配，Joe有 w 的钱。
 *
 * 第 2∼n+1行，每行两个整数 ci，di 表示 i 朵云的价钱和价值。
 *
 * 第 n+2∼n+1+m 行，每行两个整数 ui，vi，表示买 ui 就必须买 vi，同理，如果买 vi 就必须买 ui。
 *
 * 输出格式
 * 一行，表示可以获得的最大价值。
 *
 * 数据范围
 * 1≤n≤10000,
 * 0≤m≤5000,
 * 1≤w≤10000,
 * 1≤ci≤5000,
 * 1≤di≤100,
 * 1≤ui,vi≤n
 * 输入样例：
 * 5 3 10
 * 3 10
 * 3 10
 * 3 10
 * 5 100
 * 10 1
 * 1 3
 * 3 2
 * 4 2
 * 输出样例：
 * 1
 */
public class CollocationPurchase {
    static final int N = 10010;
    static int []f = new int [N]; // 价值
    static int []p = new int [N];
    static int []worth = new int[N];
    static int []cost = new int[N];
    static boolean [] v = new boolean [N];
    static int n, m ,w;
    public static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[0];
        try {
            s = br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        w = Integer.parseInt(s[2]);
        System.out.println(n);
        System.out.println(m);
        System.out.println(w);

        System.out.println("//////////////////////////");
        for(int i = 1; i <= n;i++) p[i] = i;
        for(int i = 1; i <= n ; i++){
            String[] s1 = new String[0];
            try {
                s1 = br.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            cost[i] = Integer.parseInt(s1[0]);
            worth[i] = Integer.parseInt(s1[1]);
        }
        for(int i = 1; i <= m ; i ++) {
            String[] s1 = new String[0];
            try {
                s1 = br.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int a = find(x), b = find(y);

            if(a != b) {
                p[a] = b;
                cost[b] += cost[a];
                worth[b] += worth[a];

            }

        }
        for(int i = 1; i <= n ; i++){
            int a = find(i);
            if(!v[a]) {
                for (int j = w; j >= cost[a]; j--) f[j] = Math.max(f[j], f[j - cost[a]] + worth[a]);
                v[a] = true;
            }
        }

        System.out.println(f[w]);

    }
}
