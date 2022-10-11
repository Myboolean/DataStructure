package Acwing.HighLevelDataStructure.segmentTree;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/11
 * Time: 11:19
 */
public class MaxNumber {
    static final int N = 200010;
    static int m, p;
    static class Node{
        int l, r;
        int v;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    static Node [] tr = new Node[4 * N];
    static void build(int u, int l , int r){
        tr[u] = new Node(l, r);
        if(l == r) return;
        int mid  = l + r >> 1;
        build(u << 1, l , mid); build(u << 1 | 1, mid + 1, r);
    }

    /**
     * 由子节点信息结算父节点的信息
     * @param u
     */
    static void pushUp(int u){
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }

    static int query(int u, int l, int r){
        if(tr[u].l >= l && tr[u].r <= r) return tr[u].v;

        int mid = tr[u].l + tr[u].r >> 1;
        int v = 0;
        if(l <= mid) v = query(u << 1, l, r);
        if(r > mid) v = Math.max(v, query(u << 1 | 1, l, r));
        return v;
    }
    static void modify(int u, int x ,int v){
        if(tr[u].l == x && tr[u].r == x) tr[u].v = v;
        else {
            int mid = tr[u].l + tr[u].r >> 1;
            if(x <= mid) modify(u << 1, x,v);
            else modify(u << 1 | 1, x, v);
            pushUp(u);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        p = Integer.parseInt(s[1]);
        int n = 0  , last = 0;
        build(1, 1, m);
        for (int i = 0; i < m; i++) {
            String[] s3 = br.readLine().split(" ");
            int c = Integer.parseInt(s3[1]);
            if(s3[0].equals("Q")){
                last = query(1, n - c + 1, n);
                log.write(last + "\n");
            }else {
                modify(1, n + 1, (last + c) % p );
                n++;
            }
        }
        log.flush();
    }
}
