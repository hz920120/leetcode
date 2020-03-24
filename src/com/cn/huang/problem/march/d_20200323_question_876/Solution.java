/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200323_question_876;

import com.cn.huang.utils.ListNode;

/**
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月23日 5:53 下午 huangzuo Exp $
 */
public class Solution {

    private static int depth = 1;

    public static ListNode middleNode(ListNode head) {


        return copyListNode(head,method(head)/2);

    }

    private static int method(ListNode node){
        if (node.next == null){
            return depth;
        }else {
            depth++;
            return method(node.next);
        }
    }

    private static ListNode copyListNode(ListNode ori,int index){
        while (index > 0){
            index--;
            ori = ori.next;
        }
        return ori;
    }


    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = null;
//        listNode5.next = listNode6;
//        listNode6.next = null;

        middleNode(new ListNode(1));
        System.out.println("1");
    }

}
