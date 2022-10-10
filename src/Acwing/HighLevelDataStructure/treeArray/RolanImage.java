package Acwing.HighLevelDataStructure.treeArray;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/9
 * Time: 16:23
 * 在完成了分配任务之后，西部 314 来到了楼兰古城的西部。
 *
 * 相传很久以前这片土地上(比楼兰古城还早)生活着两个部落，一个部落崇拜尖刀(V)，一个部落崇拜铁锹(∧)，他们分别用 V 和 ∧ 的形状来代表各自部落的图腾。
 *
 * 西部 314 在楼兰古城的下面发现了一幅巨大的壁画，壁画上被标记出了 n 个点，经测量发现这 n 个点的水平位置和竖直位置是两两不同的。
 *
 * 西部 314 认为这幅壁画所包含的信息与这 n 个点的相对位置有关，因此不妨设坐标分别为 (1,y1),(2,y2),…,(n,yn)，其中 y1∼yn 是 1 到 n 的一个排列。
 *
 * 西部 314 打算研究这幅壁画中包含着多少个图腾。
 *
 * 如果三个点 (i,yi),(j,yj),(k,yk) 满足 1≤i<j<k≤n 且 yi>yj,yj<yk，则称这三个点构成 V 图腾;
 *
 * 如果三个点 (i,yi),(j,yj),(k,yk) 满足 1≤i<j<k≤n 且 yi<yj,yj>yk，则称这三个点构成 ∧ 图腾;
 *
 * 西部 314 想知道，这 n 个点中两个部落图腾的数目。
 *
 * 因此，你需要编写一个程序来求出 V 的个数和 ∧ 的个数。
 *
 * 输入格式
 * 第一行一个数 n。
 *
 * 第二行是 n 个数，分别代表 y1，y2,…,yn。
 *
 * 输出格式
 * 两个数，中间用空格隔开，依次为 V 的个数和 ∧ 的个数。
 *
 * 数据范围
 * 对于所有数据，n≤200000，且输出答案不会超过 int64。
 * y1∼yn 是 1 到 n 的一个排列。
 *
 * 输入样例：
 * 5
 * 1 5 3 2 4
 * 输出样例：
 * 3 4
 */
public class RolanImage {
    static Long res = 0L;
    static int n;
    static final int N = 2000010;
    static int [] tr = new int[N];
    static int lowbit(int x) {
        return x  & (- x);
    }
    static void add(int x, int c) {
        for (int i = x; i <= n ; i+=lowbit(i)) {
            tr[i] += c;
        }
    }
    static int sum(int x){
        int res = 0 ;
        for (int i = x; i != 0 ; i -=lowbit(i)) {
            res += tr[i];
        }
        return res;
    }
    /**
     *
     * 根据最下面的点的什么来划分，一共n种情况
     * 对于y k这个点
     * 左边有多少个数在yk + 1 ~n 之间，右边有多少个数在yk + 1 之间
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        String[] s1 = br.readLine().split(" ");
        long res1 = 0L, res2 = 0L;
        for (int i = 1; i <= n ; i++) {
            int y = Integer.parseInt(s1[i-1]);
            long temp1 = sum(n) - sum(y);
            long temp2 = sum(y - 1);
            res1 += temp1 * (n - y - temp1);
            res2 += temp2 * (y - 1 - temp2);

            add(y, 1);
        }
        log.write(res1 + " " + res2);
        log.flush();
    }
}
