/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.utils;

import java.util.List;

/**
 * @author huangzuo
 * @version : Node.java, v 0.1 2020年04月17日 12:07 上午 huangzuo Exp $
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
