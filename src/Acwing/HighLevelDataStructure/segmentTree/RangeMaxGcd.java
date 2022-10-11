package Acwing.HighLevelDataStructure.segmentTree;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/11
 * Time: 15:59
 * 给定一个长度为 N 的数列 A，以及 M 条指令，每条指令可能是以下两种之一：
 *
 * C l r d，表示把 A[l],A[l+1],…,A[r] 都加上 d。
 * Q l r，表示询问 A[l],A[l+1],…,A[r] 的最大公约数(GCD)。
 * 对于每个询问，输出一个整数表示答案。
 *
 * 输入格式
 * 第一行两个整数 N,M。
 *
 * 第二行 N 个整数 A[i]。
 *
 * 接下来 M 行表示 M 条指令，每条指令的格式如题目描述所示。
 *
 * 输出格式
 * 对于每个询问，输出一个整数表示答案。
 *
 * 每个答案占一行。
 *
 * 数据范围
 * N≤500000,M≤100000,
 * 1≤A[i]≤1018,
 * |d|≤1018
 * 输入样例：
 * 5 5
 * 1 3 5 7 9
 * Q 1 5
 * C 1 5 1
 * Q 1 5
 * C 3 3 6
 * Q 2 4
 * 输出样例：
 * 1
 * 2
 * 4
 *
 * 1. 区间[L,R] 增加一个数 d
 * 求区间内的最大公约数
 * 最大公约数
 * (a1,a2,a3....,an) = (a1, a2- a1, a3 - a2, ...., an - an - 1);
 */
public class RangeMaxGcd {

    static final int N = 500010;
    static int n, m;

    static class Node {
        int l, r;
        long sum, d;// 最大公约数  可以从左右两边的最大公约数再取一个最大公约数

        // gcd(a[L), gcd(b[l +1) ~ b[r])
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, long sum, long d) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.d = d;
        }
    }

    static Node[] tr = new Node[4 * N];
    static long[] w = new long[N];

    static long gcd(long a, long b) {
        return b != 0 ? gcd(b, a % b) : Math.abs(a);
    }

    static void build(int u, int l, int r) {
        if (l == r) {
            tr[u] = new Node(l, r, w[r] - w[r - 1], w[r] - w[r - 1]);
        } else {
            tr[u] = new Node(l, r);
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }

    private static void pushUp(int u) {
        pushUp(tr[u], tr[u << 1], tr[u << 1 | 1]);
    }

    private static void pushUp(Node u, Node l, Node r) {
        u.sum = l.sum + r.sum;
        u.d = gcd(l.d, r.d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Long.parseLong(s1[i - 1]);
        }
        build(1, 1, n);
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            if (s2[0].equals("Q")) {
                int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[2]);
                Node left = query(1, 1, a), right = new Node(0, 0, 0, 0);
                if (a + 1 <= b) {
                    right = query(1, a + 1, b);

                }
                log.write(gcd(left.sum, right.d) + "\n");
            } else {
                int l = Integer.parseInt(s2[1]);
                int r = Integer.parseInt(s2[2]);
                long d = Long.parseLong(s2[3]);
                modify(1, l, d);
                if (r + 1 <= n) modify(1, r + 1, -d);
            }
        }
        log.flush();
    }

    private static void modify(int u, int x, long v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].d += v;
            tr[u].sum += v;
        } else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (x <= mid) modify(u << 1, x, v);
            else modify(u << 1 | 1, x, v);
            pushUp(u);
        }
    }

    private static Node query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u];
        int mid = tr[u].l + tr[u].r >> 1;
        if(r <= mid) return query(u << 1, l, r);
        else if(l > mid) return  query(u << 1 | 1, l, r);
        else{
            Node res, left, right;
            left = query(u << 1, l, r);
            right = query(u << 1 | 1, l, r);
            res = new Node(l, r);
            pushUp(res, left, right);
            return  res;
        }
    }


}



