package com.cn.sep2021;

import com.cn.huang.utils.ListNode;

import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-22 22:12:10
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return new ListNode[] {head};
        }

        ListNode[] res = new ListNode[k];

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            for (int i = 0; i < k; i++) {
                res[i] = null;
            }
            return res;
        }


        int groupSize = stack.size() / k;
        if (groupSize == 0) {
            int s = stack.size();
            for (int i = s - 1; i >= 0; i--) {
                if (stack.size() > 0) {
                    ListNode curr = stack.pop();
                    curr.next = null;
                    res[i] = curr;
                }
            }
//            else {
//                res[i] = null;
//            }
        } else {
            for (int i = k - 1; i >= 0; i--) {
                ListNode curr = null;
                //最后一个节点直接弹到底
                if (i == 0) {
                    curr = stack.pop();
                    curr.next = null;
                    while (!stack.isEmpty()) {
                        curr = stack.pop();
                    }
                    res[i] = curr;
                } else {
                    //其余分组数多大就弹出几次
                    for (int j = 0; j < groupSize; j++) {
                        curr = stack.pop();
                        if (j == 0) curr.next = null;
                    }
                    res[i] = curr;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SplitListToParts splitListToParts = new SplitListToParts();
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        listNode.next = new ListNode(6);
        listNode = listNode.next;
        listNode.next = new ListNode(7);
        listNode = listNode.next;
//        listNode.next = new ListNode(8);
//        listNode = listNode.next;
//        listNode.next = new ListNode(9);
//        listNode = listNode.next;
//        listNode.next = new ListNode(10);
//        listNode = listNode.next;

        splitListToParts.splitListToParts(head, 3);
    }
}
