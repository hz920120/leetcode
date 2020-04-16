/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200416_question_559;

import com.cn.huang.utils.Node;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *  
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月17日 12:00 上午 huangzuo Exp $
 */
public class Solution {
    /**
     * 与111和104类似
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null){return 0;}
        //如果没有子节点，则找到叶子节点，+1
        if (root.children.isEmpty()){
            return 1;
        }
        //如果有1个及以上的子节点，则找到子节点的最大深度返回
        int max = 0;
        for (Node child : root.children){
            int dep = maxDepth(child);
            if (dep > max){
                max = dep;
            }
        }
        return max + 1;
    }
}
