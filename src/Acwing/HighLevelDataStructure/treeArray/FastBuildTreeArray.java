package Acwing.HighLevelDataStructure.treeArray;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/10
 * Time: 11:22
 */
public class FastBuildTreeArray {
    static final int N = 100010;
    static int [] a = new int[N];
    static int [] f = new int[N];
    static int n, m;
    static int o = 0;
    static void add(int i, int c){
        for (int j = i; j <= n; j+=lowbit(j)) {
            f[j] += c;
        }
    }
    static void rangeAdd(int l, int r ,int c){
        add(l, c);
        add(r + 1, - c);
    }
    static int lowbit(int d){
        return d & (-d);
    }
    static int query(int i){
        int ans = 0;
        for (int j = i; j > 0 ; j-=lowbit(j)) {
            ans += f[j];
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
        }
        for (int i = 1; i <= n ; i++) {
            f[i] = a[i] - a[i- 1];
        }
        // 建立梳妆数组
        for (int i = 1; i <= n ; i++) {
            for (int j = i - 1; j  >=  i - lowbit(i) + 1 ; j -=lowbit(j)) {
                f[i] += f[j];
            }
        }

        for (int i = 1; i <=n ; i++) {
            System.out.println(f[i]);
        }
    }
}
