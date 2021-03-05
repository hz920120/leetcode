/*
 * Miya.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.cn.huang.problem.year2021.march;

import java.util.Stack;

/**
 * @author huangzuo
 * @version : d_20210305_232.java, v 0.1 2021年03月05日 10:49 下午 huangzuo Exp $
 */
public class d_20210305_232 {

    private Stack<Object> stack1;

    private Stack<Object> stack2;

    private boolean isFIFO;

    /** Initialize your data structure here. */
    public d_20210305_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        isFIFO = false;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (isFIFO) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
            isFIFO = false;
        } else {
            stack1.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (isFIFO) {
            return (int)stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            isFIFO = true;
            return (int)stack2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (isFIFO) {
            return (int)stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            isFIFO = true;
            return (int)stack2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (isFIFO) {
            return stack2.empty();
        }
        return stack1.empty();
    }

    public static void main(String[] args) {
        d_20210305_232 obj = new d_20210305_232();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        obj.pop();

        obj.push(4);
        System.out.println("~~"+obj.peek());
        System.out.println(1);
    }
}



/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */