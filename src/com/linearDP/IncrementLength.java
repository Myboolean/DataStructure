package com.linearDP;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/7/10
 * Time: 16:19
 * dp[i 所有以f[i结尾的严格单调上升子序列的长度
 *  朴素版本:状态转移方程的时间复杂度为O(n^2)
 * 状态划分常用的依据:“最后”，以最后一个不同的点
 */
public class IncrementLength {
//    private static int N = 1010;
//    private static int [] f = new int[N];
//    private static int [] dp = new int[N];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] s = br.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        String[] s1 = br.readLine().split(" ");
//        for (int i = 1; i <= n ; i++) {
//            f[i] = Integer.parseInt(s1[i - 1]);
//        }
//        dp[1] = 1;
//        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j < i ; j++) {
//                if(f[i] > f[j]) dp[i] = Math.max(dp[i],dp[j] + 1);
//            }
//            dp[i] = Math.max(dp[i],1);// 倒数第二个数不存在，即只有一个数
//        }
//        System.out.println(dp[n]);
//    }
//

    private static int N = 100010;
    private static int [] f = new int[N];
    private static int [] q = new int[N];
    // q的下标保存是长度，值为以这个长度下结尾的最小值
    /**
     * 优化
     * 二分优化时间复杂度
     * 长度是n的上升子序列只需要存结尾最小的一个就可以了，不需要存多个，显而易见
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            f[i] = Integer.parseInt(s1[i ]);
        }
        int len = 0;
        q[0] = (int)-2e9; //
        for (int i = 0; i < n; i++) {
            // 找到最大的小于f[i]的数
            int l = 0 ,r = len;
            while(l < r){
                int mid = (l + r + 1) / 2;
                if(q[mid] < f[i]){ l  = mid;

                }else{
                    r = mid - 1;
                }

            }
            //因为二分出的r满足q[r]是小于a[i]的最大数，所以q[r + 1]一定大于等于f[i]。
            // 更新最大的子序列长度
            len = Math.max(len, r + 1);
            //更新长度为r + 1的结尾最小值
            q[r + 1] = f[i];
        }
        System.out.println(len);
    }
}
