//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
// 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 620 👎 0

 
package leetcode.editor.cn;
 
//O(1) 时间插入、删除和获取随机元素



import java.util.*;

public class InsertDeleteGetrandomO1{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new InsertDeleteGetrandomO1().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> p = new HashMap<>();
    Random rand = new Random();
    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if(p.containsKey(val)) {
          return false;
        }
        res.add(val);
        p.put(val, res.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!p.containsKey(val)) {
            return false;
        }
        Integer index = p.get(val);

        Integer lastVal = res.get(res.size() - 1);

        res.set(index , lastVal);
        p.put(lastVal, index); // 改了之后映射也要修改
        res.set(res.size() - 1, val);
        res.remove(res.size() - 1);
        p.remove(val);
        return true;
    }
    
    public int getRandom() {

        return res.get(rand.nextInt(res.size()));
    }
}

    private class Solution {
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}