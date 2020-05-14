/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.sort_search;

/**
 * @author huangzuo
 * @version : FirstBadVersion.java, v 0.1 2020年05月12日 4:16 下午 huangzuo Exp $
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        //左指针是否变化、右指针是否变化
        boolean leftChange = false,rightChange = false;
        //左指针和右指针
        int leftPointer = 0,rightPointer = n-1;
        //循环条件：左指针小于右指针且变化指针没有变化
        while ((!leftChange && !rightChange) && (leftPointer < rightPointer)) {
            leftChange = isBadVersion(leftPointer) ^ isBadVersion(++leftPointer);
            rightChange = isBadVersion(rightPointer) ^ isBadVersion(--rightPointer);
        }
        if (leftChange){
            return leftPointer;
        }
        if (rightChange){
            return ++rightPointer;
        }
        return n;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(2));

    }
}