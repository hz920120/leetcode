/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.may.d_20200514_question_993;

import com.cn.huang.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年05月14日 4:09 下午 huangzuo Exp $
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {return false;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //树深度
        int depth = 0;
        //定义是否找到x，x的深度，x的父节点值
        boolean isX = false;
        int depthX = 0;
        int fatherX = 0;
        //定义是否找到y，y的深度，y的父节点值
        boolean isY = false;
        int depthY = 0;
        int fatherY = 0;
        //每一次while循环遍历的都是同一深度的结点
        while (!queue.isEmpty()){
            int len = queue.size();
            //遍历深度为depth的所有几点
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                //父节点值
                int father = treeNode.val;
                if (treeNode.left != null){
                    //判断左子节点是否满足输入的x或y值
                    if (treeNode.left.val == x){
                        isX = true;
                        depthX = depth;
                        fatherX = father;
                    }
                    if (treeNode.left.val == y){
                        isY = true;
                        depthY = depth;
                        fatherY = father;
                    }
                    //无论有没有找到，都把左节点塞入队列
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    //判断右子节点是否满足输入的x或y值
                    if (treeNode.right.val == x) {
                        isX = true;
                        depthX = depth;
                        fatherX = father;
                    }
                    if (treeNode.right.val == y) {
                        isY = true;
                        depthY = depth;
                        fatherY = father;
                    }
                    //无论有没有找到，都把左节点塞入队列
                    queue.offer(treeNode.right);
                }
                //x、y都找到就没必要继续找了
                if (isX && isY){
                    break;
                }
            }
            //这一深度遍历完，深度+1
            ++depth;
        }
        //如果x、y都找到，并且↓
        if(isX && isY){
            //深度大于等于2、且x、y深度相同，并且↓
            if (depth >= 2 && depthX == depthY){
                //父节点值不同，满足条件返回true
                if (fatherX != fatherY){
                    return true;
                }
            }
        }
        //没满足条件，不是堂兄弟
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isCousins(TreeNode.mkTree("[1,2,3,null,4,null,5]"),5,4);
    }
}
