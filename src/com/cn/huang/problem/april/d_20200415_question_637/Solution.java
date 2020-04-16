/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_637;

import com.cn.huang.utils.TreeNode;
import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 *
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 *
 * The range of node's value is in the range of 32-bit signed integer.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月15日 11:43 下午 huangzuo Exp $
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null){return res;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            double avg = 0.0;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
                avg += treeNode.val;
            }
            res.add(avg/len);
        }

        return res;
    }
}
