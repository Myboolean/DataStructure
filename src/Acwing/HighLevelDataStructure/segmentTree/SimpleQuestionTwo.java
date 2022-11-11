package Acwing.HighLevelDataStructure.segmentTree;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/12
 * Time: 9:09
 */
public class SimpleQuestionTwo {
    static final int N = 100010;
    static int n, m;
    static class Node{
        int l, r;
        long sum; // 区间和  如果考虑当前结点及子节点上的所有标记，当前区间和是多少
        long add; // 懒标记，给当前区间的所有儿子应该添加的数
        // 横跨左右子区间的最大子段和= 左子区间的最大后缀+右子区间的最大前缀

        public Node() {
        }

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, long sum, long add) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.add = add;
        }
    }
    static Node[] tr = new Node[4 * N];
    static int[] w = new int[N];

    /**
     * 从子节点修改父节点的值
     * @param u
     */
    static void pushUp(int u){
        tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    }


    static void build(int u, int l, int r){
        if(l == r){
            tr[u] = new Node(l, r , w[l], 0);
        }else{
            tr[u] = new Node(l, r);
            int mid =  l + r >> 1;
            build(u << 1, l, mid); build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }

    /**
     * 对有懒标记的操作进行向下赋值
     * @param u
     */
    static void pushDown(int u){
        Node root = tr[u];
        Node left = tr[u << 1];
        Node right = tr[u << 1 | 1];
        if(root.add != 0){
            left.add += root.add;
            left.sum += (long) (left.r - left.l + 1) * root.add;
            right.add += root.add;
            right.sum += (long) (right.r - right.l + 1) * root.add;
            root.add = 0;
        }
    }

    static void modify(int u,int l, int r, int d){
        if(tr[u].l >= l && tr[u].r <= r){
            tr[u].sum += (long) (tr[u].r - tr[u].l + 1) * d;
            tr[u].add += d;
        }else{
            pushDown (u);
            int mid = tr[u].l + tr[u].r >> 1;
            if (l <= mid) modify (u << 1,l,r,d);
            if (r > mid ) modify (u << 1 | 1,l,r,d);
            pushUp (u);
         }
    }
    static long query(int u,int l, int r){

        if(tr[u].l >= l && tr[u].r <= r) return tr[u].sum;

        pushDown (u);
        int mid = tr[u].l +tr[u]. r >> 1;
        long sum = 0;
        if (l <= mid) sum += query (u << 1,l,r);
        if (r > mid ) sum += query (u << 1 | 1,l,r);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        String[] s2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(s2[i - 1]);
        }

        build(1, 1, n);

        for (int i = 0; i < m; i++) {
            int l;
            String[] s1 = br.readLine().split(" ");
            l = Integer.parseInt(s1[1]);
            int r = Integer.parseInt(s1[2]);
            if (s1[0].equals("Q")) {
                log.write(query(1,l, r) + "\n");
            } else {
                int z = Integer.parseInt(s1[3]);
                modify(1, l,r, z);
            }

        }
        log.flush();

    }
}
