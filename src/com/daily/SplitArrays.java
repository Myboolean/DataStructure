package com.daily;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/24
 * Time: 9:30
 * 分割数组
 */
public class SplitArrays {
    final int N = 400010;
    static class Node{
        int left,right;
        int max;
        int min;
        public Node(int left, int right, int max, int min){
            this.left = left;
            this.right = right;
            this.max = max;
            this.min = min;
        }
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    Node [] tr = new Node[N];

    public void build(int u, int l, int r, int [] nums){
        if(l == r ) {
            tr[u] = new Node(l, r, nums[l - 1], nums[l - 1]);
            return;
        }
        tr[u] = new Node(l, r);
        int mid = l + r >> 1;
        build(u << 1, l, mid, nums);
        build(u << 1 | 1, mid + 1, r, nums);
        pushUp(u);
    }
    public void pushUp(int u){
        tr[u].max = Math.max(tr[u << 1].max, tr[u << 1 | 1].max);
        tr[u].min = Math.min(tr[u << 1].min, tr[u << 1 | 1].min);
    }
    public int  queryMax(int u, int l, int r){
        if(tr[u].left >= l && tr[u].right <= r){
            return tr[u].max;
        }
        int mid = tr[u].left + tr[u].right >> 1;
        int v = 0;
        if(l <= mid ) v = queryMax(u << 1, l, r);
        else if( r > mid)  v =  Math.max(v, queryMax(u << 1 | 1, l, r));
        return v;

    }
    private int queryMin(int u, int l, int r) {
        if(tr[u].left >= l && tr[u].right <= r) return tr[u].min;
        int mid = tr[u].left + tr[u].right >> 1;
        int v = (int) 1e9;
        if(l <= mid) v = queryMin(u << 1, l,r );
        if(r > mid) v = Math.min(v, queryMin(u <<1 | 1,l , r));
//        System.out.println(v);
        return v;
    }
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        build(1,1, n, nums);
        int leftMax  = 0;
        int rightMax = 0;
        int ans = 0;
        for (int i = 1; i <= n - 1; i++) {
            leftMax = queryMax(1, 1, i);
            rightMax = queryMin(1, i + 1, n);
            if(leftMax <= rightMax) {
                ans = i;
                break;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int [] nums = {1,1,1,0,6,12};
        SplitArrays splitArrays = new SplitArrays();
        splitArrays.build(1, 1, nums.length, nums);
        System.out.println(splitArrays.partitionDisjoint(nums));

    }
}
