package Acwing.HighLevelDataStructure.treeArray;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/10
 * Time: 11:13
 *
 * 需要从最后一头牛作为突破口，因为最后一头牛的h[n]表示，在前面的牛中，有h[n]头牛比它矮，
 * 即在所有的牛中，有h[n]头牛比他矮，因此最后一牛的高度在所有牛中排第h[n] + 1小。
 * 拿第n头牛作为信息点，去掉第n头牛，继续计算第n - 1头牛的高度，再去掉第n - 1头牛，
 * 依次类推… 当枚举到第i头牛时，在剩下的牛中高度中排第h[i] + 1小的高度，即是第i头牛的高度。
 */
public class MysticCow {

    static final int N = 100010;
    static int [] a = new int[N];
    static int [] f = new int[N];
    static int [] ans = new int[N];
    static int n, m;
    static void add(int i, int c){
        for (int j = i; j <= n; j+=lowbit(j)) {
            f[j] += c;
        }
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

        for (int i = 2; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            a[i] = Integer.parseInt(s1[0]);

        }
        for (int i = 1; i <= n ; i++) {
            add(i, 1);
        }


        for (int i = n; i >= 1 ; i--) {
            int d = a[i] + 1;
            int l = 1, r = n;
            while(l < r){
                int mid  = l + (r - l) / 2;
                if(query(mid) >= d) r = mid;
                else l = mid + 1;
            }
            ans[i] = l;
            add(l, - 1);
        }
        for (int i = 1; i <=n ; i++) {
            log.write(ans[i] + "\n");
        }
        log.flush();
    }
}
