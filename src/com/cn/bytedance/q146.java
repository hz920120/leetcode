/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : q146.java, v 0.1 2020年08月26日 1:03 上午 huangzuo Exp $
 */
public class q146 extends LinkedHashMap<Integer,Integer> {
    private int cap;

    public q146(int initialCapacity, int cap) {
        super(initialCapacity, 0.75f, true);
        this.cap = cap;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int val) {
        super.put(key,val);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > cap;
    }
}
