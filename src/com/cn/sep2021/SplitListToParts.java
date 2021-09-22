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
            return new ListNode[k];
        }

        ListNode[] res = new ListNode[k];

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) return res;
        int groupMinSize = stack.size() / k;
        int groupMaxSize = groupMinSize + 1;
        int currSize = groupMinSize;
        //从末尾开始以最小容量groupMinSize添加，添加到  stack.size() / groupMaxSize == k+1(数组前面剩余的空间) 开始以groupMaxSize添加
        for (int i = k - 1; i >= 0 ; i--) {
            if (stack.size() / groupMaxSize == i+1) currSize = groupMaxSize;
            ListNode curr = null;
            for (int j = 0; j < currSize; j++) {
                curr = stack.pop();
                if (j == 0) curr.next = null;
            }
            res[i] = curr;
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
