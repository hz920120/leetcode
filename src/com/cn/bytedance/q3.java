/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : q3.java, v 0.1 2020年08月23日 11:29 下午 huangzuo Exp $
 */
public class q3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start,map.get(c));
            }
            res = Math.max(res, end - start + 1);
            map.put(c,end + 1);
        }
        return  res;
    }
}
