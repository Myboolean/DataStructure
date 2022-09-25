package com.bag;


import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 9:36
 */

public class Bag_01 {
    private static final int N = 1010;
//    private static final int [][] f = new int[N][N];

    /**
     * f[i][j]表示在取前i件物品，体积为j的时候能取到的最大价值
     *
     * @param args
     * @throws IOException
     */
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
//            for(int j = 0 ; j <= m;j++){
//                f[i][j] = f[i-1][j];
//                if(j  >= v){
//                    f[i][j] = Math.max(f[i][j], f[i-1][j-v] + w);
//                }
//            }
//        }
//        int res = 0;
//        for(int i = 0 ; i <= m;i++) res = Math.max(res, f[n][i]);
//        System.out.println(res);
//        br.close();
//        bw.close();
//
//    }
    private static final int [] f = new int[N];
    /**
     * f[i]表示体积为i时物品价值的最大值
     * 为了保证此时的f[i]使用的状态是上一次的状态，可以让体积从大到小进行计算，保证每一次使用的体积是上一次剩下的状态
     * 此时f[m]必定为最大值
     * 证明:
     *      如果f[k] = max_w,两种情况:
     *          从f[0]转移 ==>f[v[0]] + w[0] == >  ...==> f[k]
     *          不从f[0]转移，其实本质上是一样的f那么从f[m - k]转移，因为所有的f值初始化为0，
     *          那么可以通过同样的转移路径得到f[m] = f[m - k] == > ..... ==> f[m]和f[k]的值是一样的，所以f[m]一定是最大值
     *      如果吧f[0]初始化为0,其他值初始化为负无穷，可以保证此时路径必定只能从f[0]进行转移,此时需要循环判断哪里是最大值
     * @param args
     * @throws IOException
     */
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
            for(int j = m ; j >= v;j--){
//                System.out.println(j - v);
                f[j] = Math.max(f[j], f[j-v] + w);

            }
        }
        System.out.println(f[m]);
        br.close();
        bw.close();
        int []a = new int [10010];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

    }
}
