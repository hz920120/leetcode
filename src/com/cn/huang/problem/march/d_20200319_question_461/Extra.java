/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200319_question_461;

/**
 * 输入10进制输出2进制
 * @author huangzuo
 * @version : Extra.java, v 0.1 2020年03月19日 6:10 下午 huangzuo Exp $
 */
public class Extra {

    public static int bits(int in){

        int res = 0;
        for (int i=0;i < 10;i++){
            res += (in%2) * Math.pow(10,i);
            in = (in >> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bits(7));
    }
}
