package Acwing.HighLevelDataStructure.treeArray;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/10
 * Time: 10:21
 * 区间查询和区间修改 树状数组解法
 * 能使用树状数组的解法一定可以使用线段树
 */
public class SimpleIntegerProblemTwo {
    static final int N = 100010;
    static int [] a = new int[N];
    static int [] sum1 = new int[N];
    static int [] sum2 = new int[N];
    static int n, m;
    static int o = 0;

    static void add(int i, int c){
        for (int j = i; j <= n; j+=lowbit(j)) {
            sum1[j] += c;
            sum2[j] +=  (long) i * c;
        }
    }
    static void rangeAdd(int l, int r ,int c){
        add(l, c);
        add(r + 1, - c);
    }
    static int lowbit(int d){
        return d & (-d);
    }
    static long query(int i){
        long ans = 0;
        for (int j = i; j > 0 ; j-=lowbit(j)) {
            ans += (long) (i + 1) * sum1[j] - sum2[j];
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s2[i - 1]);
            rangeAdd(i, i, a[i]);
        }
        for (int i = 0; i < m; i++) {
            int c;
            String[] s1 = br.readLine().split(" ");
            c = Integer.parseInt(s1[1]);
            if(s1[0].equals("Q")){
                int d = Integer.parseInt(s1[2]);
                log.write(query(d) - query(c - 1) + "\n");
            }else {
                int d = Integer.parseInt(s1[2]);
                int z = Integer.parseInt(s1[3]);
                rangeAdd(c, d, z);
            }
        }
        log.flush();
    }
}
