/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.sort_search;

/**
 * @author huangzuo
 * @version : VersionControl.java, v 0.1 2020年05月12日 4:17 下午 huangzuo Exp $
 */
public class VersionControl {
    boolean isBadVersion(int version) {
        if (version <= 2){
            return false;
        }
        return true;
    }
}
