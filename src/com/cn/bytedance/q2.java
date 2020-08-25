/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.ListNode;

/**
 * @author huangzuo
 * @version : q2.java, v 0.1 2020年08月24日 7:55 上午 huangzuo Exp $
 */
public class q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置预先指针，最终返回结果用
        ListNode pre = new ListNode(1);
        //设置当前指针，用于移动链表指向当前指针
        ListNode curr = pre;
        //设置进位标识
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            //节点值相加
            int val = l1val + l2val + carry;

            //算出curr节点值和是否需要进位
            int currVal = val % 10;
            carry = val > 9 ? 1 : 0;
            ListNode newList = new ListNode(currVal);
            curr.next = newList;
            curr = newList;
            //完成计算后把原链表移动到下一位
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return pre.next;
    }
}
