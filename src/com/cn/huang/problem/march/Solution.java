/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march;

import com.cn.huang.utils.ListNode;

import java.util.*;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月14日 5:08 下午 huangzuo Exp $
 */
public class Solution {

    private Deque<Integer> ln1 = new ArrayDeque<>();
    private Deque<Integer> ln2 = new ArrayDeque<>();
    private int length;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ln1.push(l1.val);
        num1(l1);

        ln2.push(l2.val);
        num2(l2);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (ln1.size() > 0){
            sb1.append(ln1.pop());
        }
        while (ln2.size() > 0){
            sb2.append(ln2.pop());
        }

        String str;
        char[] sum = String.valueOf(Integer.valueOf(sb1.reverse().toString()) + Integer.valueOf(sb2.reverse().toString())).toCharArray();

        //7807

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < sum.length; i++) {
            res.add(sum[i]-'0');
        }
        length = res.size();

        ListNode listNode = new ListNode(0);
        addNode(listNode,res,0);
        return listNode;
    }

    private void addNode(ListNode f,List<Integer> res,int n){
        if (n == length){f = null;return;}
        f.val = res.get(n);
        if (n != length - 1) {f.next = new ListNode(0);}
        addNode(f.next,res,n+1);
    }

    private void num1(ListNode ln){
        if (ln.next == null){
            return ;
        }
        ln1.push(ln.next.val);
        num1(ln.next);
    }

    private void num2(ListNode ln){
        if (ln.next == null){
            return;
        }
        ln2.push(ln.next.val);
        num2(ln.next);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        List<Integer> res = new LinkedList<>();
        res.add(2);
        res.add(3);
        res.add(4);
        solution.length = res.size();
        solution.addNode(listNode,res,0);
        System.out.println(1);
    }
}
