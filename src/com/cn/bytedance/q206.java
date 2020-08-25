/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.ListNode;

/**
 * @author huangzuo
 * @version : q206.java, v 0.1 2020年08月24日 12:29 下午 huangzuo Exp $
 */
public class q206 {

    //1->2->3->4->5->NULL
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


}
