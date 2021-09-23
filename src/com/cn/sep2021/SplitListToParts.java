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
        if (head == null || k == 0) {
            return new ListNode[k];
        }

        ListNode[] res = new ListNode[k];

        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }

        int minSize = n/k;
        if (minSize == 0) {
            for (int i = 0; i < k; i++) {
                res[i] = head;
                ListNode t = head.next;
                head.next = null;
                head = t;
                if (head == null) return res;
            }
        } else {
            int maxSize = minSize + 1;
            int currSize = maxSize;

            for (int i = 0; i < k; i++) {
                if ((k - i == n / minSize) && (n % minSize == 0)) currSize = minSize;

                res[i] = head;
                for (int j = 1; j < currSize; j++) {
                    head = head.next;
                }
                n -= currSize;
                ListNode t = head.next;
                head.next = null;
                head = t;
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
        listNode.next = new ListNode(8);
        listNode = listNode.next;
        listNode.next = new ListNode(9);
        listNode = listNode.next;
        listNode.next = new ListNode(10);
        listNode = listNode.next;
        listNode.next = new ListNode(11);
        listNode = listNode.next;
        listNode.next = new ListNode(12);
        listNode = listNode.next;
        listNode.next = new ListNode(13);
        listNode = listNode.next;
        listNode.next = new ListNode(14);
        listNode = listNode.next;
        listNode.next = new ListNode(15);
        listNode = listNode.next;

        splitListToParts.splitListToParts(head, 10);
    }
}
