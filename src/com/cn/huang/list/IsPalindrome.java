/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

import java.util.Stack;

/**
 *  回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author huangzuo
 * @version : IsPalindrome.java, v 0.1 2020年05月24日 10:49 下午 huangzuo Exp $
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode rListNode = reverseList(head);
        while (head != null && rListNode != null){
            if (head.val == rListNode.val){
                head = head.next;
                rListNode = rListNode.next;
                continue;
            }else {
                return false;
            }
        }
        return (head == null) & (rListNode == null);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode curr = head,pre = null,temp;
        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;

        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(head);
    }
}
