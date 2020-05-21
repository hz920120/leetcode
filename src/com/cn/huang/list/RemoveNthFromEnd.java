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

        // 开辟两个指针，且第二个指针距离第一个指针为n+1，
        // 因为要删除节点，必须获得该待删除节点的前一个节点。。。。。
        ListNode node1 = head;
        ListNode node2 = head;
        node2 = move(node2,n+1);

        // 判定一下特殊情况
        // 比如链表长度为5，删除倒数第五个，就是删除第一个。
        if(null == move(head,n)) return head.next;

        // 移动两个指针，直到后面的指针移动到了null节点，也就是链表结束位置
        while(node2 != null){
            node1 = move(node1,1);
            node2 = move(node2,1);
        }

        // 删除倒数第n个节点
        node1.next = node1.next.next;
        return head;
    }

    // move towards the end of list
    ListNode move(ListNode node, int step){
        for(int i = 0; i<step; i++){
            if(node.next == null) return null;
            node = node.next;
        }
        return node;
    }


    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd.removeNthFromEnd(head,2);
    }
}
