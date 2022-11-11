//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 308 👎 0

 
package leetcode.editor.cn;
 
//最短的桥

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestBridge{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new ShortestBridge().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int [][] grid, coordinates = {{0,1},{0,-1},{-1,0}, {1,0}};
    Deque<int[]> edges;
    int n, m;
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        edges = new ArrayDeque<>();
        boolean isFindIsland = false;
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    markeIsland(i, j);
                    isFindIsland = true;
                    break;
                }
            }
            if(isFindIsland) break;
        }

        int ans = 0;
        while (!edges.isEmpty()){
            ans++;
            int nums = edges.size();
            for (int i = 0; i < nums; i++) {
                int[] edge = edges.removeFirst();
                for (int [] c:
                        coordinates) {
                    int nex = edge[0] + c[0], ney = edge[1] + c[1];
                    if(isLegal(nex, ney) && grid[nex][ney] == 0) {
                        grid[nex][ney] = 2;
                        edges.addLast(new int [] {nex, ney});
                    }else if(isLegal(nex, ney) && grid[nex][ney] == 1) return ans;
                }
            }


        }
        return ans;
    }

    private void markeIsland(int x, int y) {
        if(!isLegal(x,y) || grid[x][y] == 2) return;
        if(grid[x][y] == 0) {
            grid[x][y] = 2;
            edges.addLast(new int[]{x, y});
            return;
        }
        grid[x][y] = 2;
        for (int [] c:
             coordinates) {
            int nex = x + c[0], ney = y + c[1];
            markeIsland(nex, ney);

        }
    }

    private boolean isLegal(int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}