//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 216 👎 0

 
package leetcode.editor.cn;
 
//拼车
 
public class CarPooling{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new CarPooling().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] diff = new int [100010];
    boolean direction = false;
    int m = 0;
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips[0][1] > trips[0][2]) {
            direction = true;
        }
        int []res = new int [1010];
        int r = trips.length;

        for (int i = 0; i < r; i++) {
            int count = trips[i][0], l = trips[i][1], right = trips[i][2];
            insert(diff, l, right , count);
            m = Math.max(m, l);
            m = Math.max(m, right);
        }
        res[0] = diff[0];

        for (int i = 1; i < m; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        for (int i = 0; i < m; i++) {
            if(res[i] > capacity){
                return false;
            }
        }
        return true;
    }
    public void insert(int [] nums, int l, int r, int count) {
        nums[l] += count;
        nums[r] -=count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}