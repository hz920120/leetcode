/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.ListNode;

/**
 * @author huangzuo
 * @version : q25.java, v 0.1 2020年08月26日 11:11 上午 huangzuo Exp $
 */
public class q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //以下判断的是节点数小于k的情况，直接返回
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        int i = k;
        while (i > 0 && curr != null) {
            curr = curr.next;
            i--;
        }
        if (i > 0) {return head;}
        //结束


        //返回的结点
        ListNode res = reverseKGroup(curr,k);
        curr = head;
        i = k;
        while (i > 0) {
            //临时结点保存顺序节点信息，如4->5->6的结点保存5->6
            ListNode tmp = curr.next;
            //拿走的4拼接递归内部的节点
            curr.next = res;
            //拼接的节点变成curr
            res = curr;
            //拿回5->6;
            curr = tmp;
            //i--
            i--;
        }

        return res;
    }

}
