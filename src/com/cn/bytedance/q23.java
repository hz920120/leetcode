/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author huangzuo
 * @version : q23.java, v 0.1 2020年08月24日 11:14 下午 huangzuo Exp $
 */
public class q23 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode);
                listNode = listNode.next;
            }
        }

        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        temp.next = null;
        return res.next;
    }
}
