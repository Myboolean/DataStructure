package Acwing.HighLevelDataStructure.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/30
 * Time: 9:16
 * Alice和Bob玩了一个古老的游戏：首先画一个 n×n 的点阵（下图 n=3 ）。
 *
 * 接着，他们两个轮流在相邻的点之间画上红边和蓝边：
 *
 * 1.png
 *
 * 直到围成一个封闭的圈（面积不必为 1）为止，“封圈”的那个人就是赢家。因为棋盘实在是太大了，他们的游戏实在是太长了！
 *
 * 他们甚至在游戏中都不知道谁赢得了游戏。
 *
 * 于是请你写一个程序，帮助他们计算他们是否结束了游戏？
 *
 * 输入格式
 * 输入数据第一行为两个整数 n 和 m。n表示点阵的大小，m 表示一共画了 m 条线。
 *
 * 以后 m 行，每行首先有两个数字 (x,y)，代表了画线的起点坐标，接着用空格隔开一个字符，假如字符是 D，则是向下连一条边，如果是 R 就是向右连一条边。
 *
 * 输入数据不会有重复的边且保证正确。
 *
 * 输出格式
 * 输出一行：在第几步的时候结束。
 *
 * 假如 m 步之后也没有结束，则输出一行“draw”。
 *
 * 数据范围
 * 1≤n≤200，
 * 1≤m≤24000
 * 输入样例：
 * 3 5
 * 1 1 D
 * 1 1 R
 * 1 2 D
 * 2 1 R
 * 2 2 D
 * 输出样例：
 * 4
 */
public class CellGame {
    static final int N = 40010;
    static int []p = new int[N];
    static int n, m;
    public static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = new String[0];
        try {
            s1 = br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for (int i = 0; i < n * n; i++) {
            p[i] = i;
        }
        int res = 0;
        for (int i = 1; i <= m ; i++) {
            int x, y;
            char d;

            String[] s;
            try {
                s = br.readLine().split(" ");
                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);
                x--;
                y--; // x, y 需要从0开始
                d = s[2].charAt(0);
                int a = get(x, y);
                int b;
                if(d == 'D') b = get(x + 1, y);
                else b = get(x , y + 1);

                int pa = find(a),pb = find(b);

                if(pa == pb) {
                    res = i;
                    break;
                }
                p[pa] = pb;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(res > 0) System.out.println(res);
        else System.out.println("draw");

    }

    private static int get(int x, int y) {
        return n * x  + y;
    }


}
