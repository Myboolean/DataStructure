package Acwing.HighLevelDataStructure.segmentTree;


import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/11
 * Time: 14:31
 *
 * 给定长度为 N 的数列 A，以及 M 条指令，每条指令可能是以下两种之一：
 *
 * 1 x y，查询区间 [x,y] 中的最大连续子段和，即 maxx≤l≤r≤y{∑i=lrA[i]}。
 * 2 x y，把 A[x] 改成 y。
 * 对于每个查询指令，输出一个整数表示答案。
 *
 * 输入格式
 * 第一行两个整数 N,M。
 *
 * 第二行 N 个整数 A[i]。
 *
 * 接下来 M 行每行 3 个整数 k,x,y，k=1 表示查询（此时如果 x>y，请交换 x,y），k=2 表示修改。
 *
 * 输出格式
 * 对于每个查询指令输出一个整数表示答案。
 *
 * 每个答案占一行。
 *
 * 数据范围
 * N≤500000,M≤100000,
 * −1000≤A[i]≤1000
 * 输入样例：
 * 5 3
 * 1 2 -3 4 5
 * 1 2 3
 * 2 2 -1
 * 1 3 2
 * 输出样例：
 * 2
 * -1
 * 如何思考，
 * --------------------
 * -------- -----------
 * 上端是否能由下面两段直接得出，不能得出需要哪些信息
 *
 * 可以解决连续最大前缀和最后后缀  以及区间和的问题
 */
public class CanYouAnswerTheseQuestions {
    static final int N = 500010;
    static int n, m;
    static class Node{
        int l, r;
        int tMax;// 最大连续子段和  tMax = Math.max(left tMax.right tMax, left rMax + right rMax)
        int lMax;// 最大前缀 lMax = Math.max(left sum + right lMax)
        int rMax; //最大后缀和
        int sum; // 区间和
        // 横跨左右子区间的最大子段和= 左子区间的最大后缀+右子区间的最大前缀

        public Node() {
        }

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, int tMax, int lMax, int rMax, int sum) {
            this.l = l;
            this.r = r;
            this.tMax = tMax;
            this.lMax = lMax;
            this.rMax = rMax;
            this.sum = sum;
        }
    }
    static Node[] tr = new Node[4 * N];
    static int[] w = new int[N];
    static void build(int u, int l, int r){
        if(l == r){
            tr[u] = new Node(l, r, w[l], w[l], w[l], w[l]);
        }else{
            tr[u] = new Node(l, r); // 防止pushUp的时候内存未开辟
            int mid = l + r >> 1;
            build(u << 1, l, mid); build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }
    static void pushUp(Node u, Node l, Node r){
        u.sum = l.sum + r.sum;
        u.lMax = Math.max(l.lMax , l.sum + r.lMax);
        u.rMax = Math.max(r.rMax, r.sum + l.rMax);
        u.tMax = Math.max(Math.max(l.tMax, r.tMax), l.rMax + r.lMax);

    }
    static void pushUp(int u){
        pushUp(tr[u], tr[u  << 1], tr[u << 1 | 1]); // 2 * u和 2 * u  + 1
    }

    static void modify(int u, int x, int v){
        if(tr[u].l == x && tr[u].r == x){
            tr[u] = new Node(x, x, v, v, v, v);
        }else {
            int mid = tr[u].l + tr[u].r >> 1;
            if(x <= mid) modify(u << 1, x, v);
            else modify(u << 1 | 1, x,  v);
            pushUp(u);
        }
    }
    static Node query(int u, int l, int r){

        if(tr[u].l >= l && tr[u].r <= r) return tr[u];
        else {
            int mid = tr[u].l + tr[u].r >> 1;
            if(r <= mid) return  query(u << 1, l, r);
            else if(l > mid) return query(u << 1 | 1, l, r);
            else {
                Node left = query(u << 1, l, r);
                Node right = query(u << 1 | 1, l , r);
                Node res = new Node(l, r);
                pushUp(res, left, right);
                return res;
            }
        }
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        for(int i = 1; i <= n ;i++){
            w[i] = Integer.parseInt(s1[i - 1]);
        }
        build(1,1, n);

        int k, x, y;
        while(m -- > 0){
            String[] s2 = br.readLine().split(" ");
            k = Integer.parseInt(s2[0]);
            x = Integer.parseInt(s2[1]);
            y = Integer.parseInt(s2[2]);
            if(k == 1){
                if(x > y) {
                    int tmp = x;
                    x= y;
                    y = tmp;
                }
                log.write(query(1, x, y).tMax + "\n");
            }else modify(1, x, y);
        }
        log.flush();
    }
}
