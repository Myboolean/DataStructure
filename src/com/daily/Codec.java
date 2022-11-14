package com.daily;

import learn.tree.TreeNode;




/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/14
 * Time: 15:30
 */
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) {
            return "#";
        }
        String res = String.valueOf(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        return res + left + right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        System.out.println(data);
        if(data.charAt(0) == '#') {
            return null;
        }

        return traverse(data, 0);

    }
    public static  TreeNode traverse( String data, int index) {
        if(index * 2 + 2 >= data.length()) {
            System.out.println(false);
            return null;
        }
        if(data.charAt(index * 2 + 2) == '#' && data.charAt(index * 2+ 1) == '#') {
            return null;
        }
        TreeNode root = new TreeNode(data.charAt(index) - '0');
        if(data.charAt(index * 2 + 1) != '#') {
            root.left = traverse(data, index * 2 + 1);
        }
        if(data.charAt(index * 2 + 2) != '#') {
            root.right = traverse(data, index * 2 + 2);
        }
        return root;
    }


    public static void sys(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        sys(root.left);
        sys(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root.left;
        TreeNode right = root.right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        String serialize = serialize(root);
        System.out.println(serialize);
        sys(deserialize(serialize));
    }
}
