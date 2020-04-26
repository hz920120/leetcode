/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200426_question_23;

import com.cn.huang.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月26日 10:24 下午 huangzuo Exp $
 */
public class Solution {
    private List<Integer> nodes = new ArrayList<>();
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){return null;}
        for (ListNode node : lists){
            addList(node);
        }
        if (nodes.isEmpty()){
            return null;
        }
        Collections.sort(nodes);
        ListNode res = new ListNode(nodes.get(0));
        nodes.remove(0);
        resNode(res);
        return res;
    }

    private void addList(ListNode node){
        if (node == null){return;}
        nodes.add(node.val);
        addList(node.next);
    }

    private void resNode(ListNode node){
        if (nodes.isEmpty()){return;}
        node.next = new ListNode(nodes.get(0));
        nodes.remove(0);
        resNode(node.next);
    }

    public static void main(String[] args) {
        ListNode listNode1 =  new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 =  new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 =  new ListNode(2);
        listNode3.next = new ListNode(6);

//        ListNode[] lists = new ListNode[]{listNode1,listNode2,listNode3};
        ListNode[] lists = new ListNode[]{null,null,null};
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);
        System.out.println(1);
    }
}
