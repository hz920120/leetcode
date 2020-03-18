/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.d_20200317_question_110;

/**
 * @author huangzuo
 * @version : Solution2.java, v 0.1 2020年03月18日 10:44 上午 huangzuo Exp $
 */
public class Solution2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        //左节点深度与右节点深度差不能超过1 && 左节点平衡 && 右节点平衡
        return Math.abs(depth(root.left)-depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }


    public static void main(String[] args) {

//        TreeNode root =    new TreeNode(1);
//        TreeNode left1 =   new TreeNode(2);
//        TreeNode left11 =  new TreeNode(3);
//        TreeNode left12 =  new TreeNode(3);
//        TreeNode left111 = new TreeNode(4);
//        TreeNode left112 = new TreeNode(4);
//        TreeNode right1 =  new TreeNode(2);
//
//        root.left = left1;
//        root.right = right1;
//        left1.left = left11;
//        left1.right = left12;
//        left11.left = left111;
//        left11.right = left112;

        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right11 = new TreeNode(15);
        TreeNode right12 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        right1.left = right11;
        right1.right = right12;

        System.out.println(isBalanced(root));
    }
}
