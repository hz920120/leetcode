/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author huangzuo
 * @version : HasCycle.java, v 0.1 2020年05月25日 11:12 下午 huangzuo Exp $
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(head.hashCode());
        System.out.println(head.next.hashCode());
        System.out.println(head.next.next.hashCode());
        System.out.println(head.next.next.next.hashCode());
    }

}
