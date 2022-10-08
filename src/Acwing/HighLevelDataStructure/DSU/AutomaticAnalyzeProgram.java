package Acwing.HighLevelDataStructure.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/30
 * Time: 17:08
 * 在实现程序自动分析的过程中，常常需要判定一些约束条件是否能被同时满足。
 *
 * 考虑一个约束满足问题的简化版本：假设 x1,x2,x3,… 代表程序中出现的变量，给定 n 个形如 xi=xj 或 xi≠xj 的变量相等/不等的约束条件，请判定是否可以分别为每一个变量赋予恰当的值，使得上述所有约束条件同时被满足。
 *
 * 例如，一个问题中的约束条件为：x1=x2，x2=x3，x3=x4，x1≠x4，这些约束条件显然是不可能同时被满足的，因此这个问题应判定为不可被满足。
 *
 * 现在给出一些约束满足问题，请分别对它们进行判定。
 *
 * 输入格式
 * 输入文件的第 1 行包含 1 个正整数 t，表示需要判定的问题个数，注意这些问题之间是相互独立的。
 *
 * 对于每个问题，包含若干行：
 *
 * 第 1 行包含 1 个正整数 n，表示该问题中需要被满足的约束条件个数。
 *
 * 接下来 n 行，每行包括 3 个整数 i,j,e，描述 1 个相等/不等的约束条件，相邻整数之间用单个空格隔开。若 e=1，则该约束条件为 xi=xj；若 e=0，则该约束条件为 xi≠xj。
 *
 * 输出格式
 * 输出文件包括 t 行。
 *
 * 输出文件的第 k 行输出一个字符串 YES 或者 NO，YES 表示输入中的第 k 个问题判定为可以被满足，NO 表示不可被满足。
 *
 * 数据范围
 * 1≤n≤105
 * 1≤i,j≤109
 * 输入样例：
 * 2
 * 2
 * 1 2 1
 * 1 2 0
 * 2
 * 1 2 1
 * 2 1 1
 * 输出样例：
 * NO
 * YES
 *
 *
 * 1. 离散化
 *     保序：排序 判重 + 二分
 *     不要求保序 ：
 *              map
 *              hash表
 *
 * 1. 约束条件顺序不存在影响
 *      1.先考虑所有相等约束， i, j 合并,不会出现矛盾
 *      2.再考虑不等条件 ，条件出现矛盾是出现在i , j 不相等且已经在同一个集合中
 */
public class AutomaticAnalyzeProgram {
    static final int N = 2000010;
    static Map<Integer, Integer> p = new HashMap<>();
    static int n, m;
    static Query [] query = new Query [N];
    static int [] l = new int [N];
    static class Query{
        int x, y, e;

        public Query(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    public static int get(int t){ // 哈希表离散化
        if(!p.containsKey(t)) {
            p.put(t, ++n);
        }
        return p.get(t);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        s = br.readLine();

        int d = Integer.parseInt(s);
        for (int k = 0; k < d; k++) {
            n = 0;
            p.clear();
            String s1 = br.readLine();
            m = Integer.parseInt(s1);
            for (int i = 0; i < m; i++) {
                int x, y , e;
                String[] s2 = br.readLine().split(" ");
                x = Integer.parseInt(s2[0]);
                y = Integer.parseInt(s2[1]);
                e = Integer.parseInt(s2[2]);
                query[i] = new Query(get(x), get(y), e);
            }
            for (int i = 1; i <= n; i++) {
                l[i] = i;
            }
            // 合并所有相等条件
            for (int i = 0; i < m; i++) {
                if(query[i].e == 1) {
                    int pa = find(query[i].x), pb = find(query[i].y);
                    l[pa] = pb;
                }
            }
            // 检查所有不等条件
            boolean has_conflict = false;
            for (int i = 0; i < m; i++) {
                if(query[i].e == 0) {
                    int pa = find(query[i].x), pb = find(query[i].y);
                    if(pa == pb) {
                        has_conflict = true;
                        break;
                    }
                }
            }
            if(has_conflict) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    private static int find(int d) {
        if(l[d] != d) l[d] = find(l[d]);
        return l[d];
    }
}
