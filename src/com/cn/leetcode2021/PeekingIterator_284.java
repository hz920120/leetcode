package com.cn.leetcode2021;

import java.util.Iterator;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-05 09:48:36
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class PeekingIterator_284 implements Iterator<Integer> {

    Iterator<Integer> iter;

    Integer next;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }
}
