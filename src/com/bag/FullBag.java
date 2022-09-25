package com.bag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 10:24
 */
public class FullBag {
    private static final int N = 20010;
    private static final int [] f = new int[N];

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] s = br.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        // 每次输入一堆v，w值，因为对于dp来说每一次都是用一组v，w值取更新，所以可以不用数组来接收
//        for (int i = 1; i <= n ; i++) {
//            String[] s1 = br.readLine().split(" ");
//            int v = Integer.parseInt(s1[0]);
//            int w = Integer.parseInt(s1[1]);
//            for(int j = m ; j >= v;j--){
////                System.out.println(j - v);
//                for(int k = 1; k * v<= j;k++)
//                    f[j] = Math.max(f[j], f[j-k * v] + k * w);
//
//            }
//        }
//        System.out.println(f[m]);
//        br.close();
//        bw.close();
//
//    }

    /**
     * 二进制优化算法
     * 转换为0,1背包问题，分成s份放入物品堆当中,那么7 可以被拆成 1 2 4三种数据来表示0-7中的所有数
     * 1000 * 11 * 2000 = 千万复杂度
     * @param args
     * @throws IOException
     */
//    static List<Goods> list = new ArrayList<Goods>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] s = br.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        // 每次输入一堆v，w值，因为对于dp来说每一次都是用一组v，w值取更新，所以可以不用数组来接收
//        for (int i = 1; i <= n ; i++) {
//            String[] s1 = br.readLine().split(" ");
//            int v = Integer.parseInt(s1[0]);
//            int w = Integer.parseInt(s1[1]);
//            int s2 = Integer.parseInt(s1[2]);
//            for (int k = 1; k <= s2 ; k *=2) {
//                s2 -= k;
//                list.add(new Goods(v * k, w * k));
//            }
//            if(s2 > 0){
//                list.add(new Goods(s2 * v, s2 * w));
//            }
//        }
//        for (Goods good :list) {
//            for (int j = m; j >= good.getV(); j--) {
//                f[j] = Math.max(f[j],f[j-good.getV()] + good.getW());
//            }
//        }
//        System.out.println(f[m]);
//        br.close();
//        bw.close();
//
//    }

//    static List<Goods> list = new ArrayList<Goods>();

    /**
     * 单调队列优化方法
     * 1000 20000 20000
     * @param args
     * @throws IOException
     */
    private static final int [] q = new int[N];
    private static final int [] g = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        // 每次输入一堆v，w值，因为对于dp来说每一次都是用一组v，w值取更新，所以可以不用数组来接收
        for (int i = 1; i <= n ; i++) {
            String[] s1 = br.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int w = Integer.parseInt(s1[1]);
            int s2 = Integer.parseInt(s1[2]);
            System.arraycopy(f,0,g,0,N);

            for (int j = 0; j < v; j++) {// 分为v类
                int hh = 0,tt = -1;
                for(int k = j; k <= m; k+=v){ //在不超过容量的基础上
                    if(hh <= tt && k - s2 * v > q[hh]) hh++; // k-s2 *v >q[hh]说明这个时候的状态不可能由q[hh]这里转移过来
                    //因为 此时就算从q[hh]加所有的s2个物品也不能转移到这个容积来

                    while(hh <= tt && g[q[tt]] + (k - q[tt]) / v * w<= g[k] ) --tt;
                    q[++tt] = k;
                    if(hh <= tt) f[k] = Math.max(f[k] - (k - q[hh]) / v * w, g[q[hh]] + (k - q[hh]) / v * w);
                }
            }
        }

        System.out.println(f[m]);
        br.close();
        bw.close();

    }
}
//
///**
// * 二进制优化方法
// */
//class Goods{
//    private int v;
//    private int w;
//
//    public Goods() {
//    }
//    public Goods(int v,int w) {
//        this.v = v;
//        this.w = w;
//    }
//    public  int getV() {
//        return v;
//    }
//
//    public  void setV(int v) {
//        this.v = v;
//    }
//
//    public  int getW() {
//        return w;
//    }
//
//    public void setW(int w) {
//        this.w = w;
//    }
//}
