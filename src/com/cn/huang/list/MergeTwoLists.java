/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

import java.util.List;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author huangzuo
 * @version : MergeTwoLists.java, v 0.1 2020年05月24日 10:13 下午 huangzuo Exp $
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res,head;
        if (l1.val < l2.val){
            res = new ListNode(l1.val);
            l1 = l1.next;
            head = res;
        }else if (l1.val > l2.val){
            res = new ListNode(l2.val);
            l2 = l2.next;
            head = res;
        }else {
            res = new ListNode(l1.val);
            head = res;
            res.next = new ListNode(l2.val);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
                continue;
            }
            if (l1.val > l2.val){
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
                continue;
            }
            if (l1.val == l2.val){
                res.next = new ListNode(l1.val);
                res.next.next = new ListNode(l2.val);
                res = res.next.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
        }
        if (l1 != null){
            res.next = l1;
        }
        if (l2 != null){
            res.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(l1,l2);
    }
}
