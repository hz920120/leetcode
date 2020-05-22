/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

/**
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author huangzuo
 * @version : RemoveNthFromEnd.java, v 0.1 2020年05月22日 12:24 上午 huangzuo Exp $
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //没有节点
        if (head == null){
            return null;
        }
        ListNode end,now = head,pre = head;
        for (int i = 0; ; i++) {
            end = getNode(now,n);
            if (i==0 && end == null){
                return head.next;
            }
            if (end == null){
                pre.next = now.next;
                return head;
            }else {
                pre = now;
                now = now.next;
            }
        }
    }

    private ListNode getNode(ListNode head,int n){
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd.removeNthFromEnd(head,2);
        System.out.println(1);
    }
}
