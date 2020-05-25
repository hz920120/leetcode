/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.list;

import com.cn.huang.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : HasCycle.java, v 0.1 2020年05月25日 11:12 下午 huangzuo Exp $
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; ; i++) {
            if (head == null){
                return false;
            }
            if (map.get(head.hashCode()) == null) {
                map.put(head.hashCode(),i);
                head = head.next;
            }else {
                return true;
            }
        }
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
