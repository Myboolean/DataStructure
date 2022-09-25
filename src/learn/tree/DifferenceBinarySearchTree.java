package learn.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/21
 * Time: 17:22
 */
public class DifferenceBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            List<TreeNode> list = new LinkedList<>();
            return list;
        }
        return generateTrees(1, n);

    }
    private List<TreeNode> generateTrees(int start , int end){
        List<TreeNode> list = new LinkedList<>();
        if(start > end) {
            list.add(null);
            return list;
        }

        for(int i = start ; i <= end; i++){

            List<TreeNode> leftNodes = new LinkedList<>();
            leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = new LinkedList<>();

            rightNodes = generateTrees(i + 1, end);

            // TreeNode node = new TreeNode(i); 在这里是错误的，不理解
            for (int j = 0; j < leftNodes.size(); j++) {
                for (int k = 0; k < rightNodes.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNodes.get(j);
                    node.right = rightNodes.get(k);
                    list.add(node);
                }
            }
        }
        return list;
    }
}
