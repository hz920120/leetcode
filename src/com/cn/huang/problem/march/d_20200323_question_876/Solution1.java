/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200323_question_876;

import com.cn.huang.utils.ListNode;

/**
 *
 * 快慢指针法
 *
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月23日 11:04 下午 huangzuo Exp $
 */
public class Solution1 {

    public static ListNode middleNode(ListNode head) {

        if (head.next == null){
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;

        while (fast.next!=null){
            fast = fast.next;
            if (fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
//        listNode5.next = listNode6;
//        listNode6.next = null;

        middleNode(listNode1);
        System.out.println("1");
    }


}
