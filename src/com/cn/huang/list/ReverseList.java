/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author huangzuo
 * @version : ReverseList.java, v 0.1 2020年05月23日 10:46 下午 huangzuo Exp $
 *
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null){
            listNodes.add(0,new ListNode(head.val));
            head = head.next;
        }

        ListNode res = new ListNode(listNodes.get(0).val);
        ListNode resHead = res;
        for (int i = 1; i < listNodes.size(); i++) {
            resHead.next = listNodes.get(i);
            resHead = resHead.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(head);
        System.out.println(1);
    }
}
