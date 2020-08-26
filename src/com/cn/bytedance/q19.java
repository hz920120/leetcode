/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author huangzuo
 * @version : q19.java, v 0.1 2020年08月26日 12:24 上午 huangzuo Exp $
 */
public class q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1), start = pre, end = pre;
        pre.next = head;
        for (int i = 0; i < n; i++) {
            if (start.next == null) {
                break;
            }
            start = start.next;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
