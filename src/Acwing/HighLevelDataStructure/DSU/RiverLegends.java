package Acwing.HighLevelDataStructure.DSU;

import learn.setandmap.map.Map;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/9
 * Time: 14:44
 */
public class RiverLegends {
    static int N = 30010;
    static int n,k;
    static int[] p = new int[N];
    static int[] size = new int[N];//集合的大小
    static int[] d = new int[N];//到根结点的距离
    static int find(int x)
    {
        if(p[x] != x)
        {
            int root = find(p[x]);
            d[x] += d[p[x]];
            p[x] = root;
        }
        return p[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for(int i = 1;i <= 30000;i ++)
        {
            p[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            String op = s1[0];
            int a = Integer.parseInt(s1[1]);
            int b = Integer.parseInt(s1[2]);
            if(s1[0].equals("M")){
                int pa = find(a), pb =find(b);
                if(pa != pb) {
                    p[pa] = pb;
                    d[pa] = size[pb];  // 因为根绝点本身的距离就是0，所以加和不加结果相同
                    size[pb] += size[pa];
                }
            }else {
                int pa = find(a), pb =find(b);
                if(pa == pb) {
                    log.write(Math.abs(d[a] - d[b]) - 1 +"\n") ;
                } else {
                    log.write(-1 + "\n");
                }

            }
        }
        log.flush();
    }
}
