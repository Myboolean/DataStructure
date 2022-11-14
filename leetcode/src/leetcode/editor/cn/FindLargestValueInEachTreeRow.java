//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 284 👎 0

 
package leetcode.editor.cn;
 
//在每个树行中找最大值

import leetcode.editor.cn.MaximumDepthOfBinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new FindLargestValueInEachTreeRow().new Solution();
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while(!q.isEmpty()) {
            Node poll = q.poll();
            TreeNode node = poll.node;
            int depth = poll.depth;
            if(res.size() <= depth) {
                res.add(node.val);
            } else {
                res.set(depth,Math.max(res.get(depth), node.val));
            }
            if(node.left != null) {
                q.offer(new Node(node.left, depth + 1));
            }
            if(node.right != null) {
                q.offer(new Node(node.right, depth + 1));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}