/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * @author huangzuo
 * @version : IsValidSudoku.java, v 0.1 2020年04月30日 12:01 上午 huangzuo Exp $
 */
public class IsValidSudoku {
    private char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            //找(0,0)(1,1)(2,2)一直到(8,8)所在的行或列是否满足条件，不满足直接返回
            if (!judgeRowColumn(i)){return false;}
        }
        //检查子数独是否满足条件
        return judgeAllSubBox();
    }

    //判断索引所在row和colunm是否满足有效条件
    private boolean judgeRowColumn(int index){
        //key是格子上的数，value是所在行或列的下标
        Map<Integer, Integer> num = new HashMap<>(9);
        //寻找行是否有重复
        for (int i = 0; i < 9; i++) {
            if (board[index][i] == '.'){continue;}
            if (num.containsKey(board[index][i]-'0')){
                return false;
            }else {
                num.put(board[index][i]-'0',i);
            }
        }
        num.clear();
        //寻找列是否有重复
        for (int i = 0; i < 9; i++) {
            if (board[i][index] == '.'){continue;}
            if (num.containsKey(board[i][index]-'0')){
                return false;
            }else {
                num.put(board[i][index]-'0',i);
            }
        }
        return true;
    }

    //判断所有子数独是否满足条件，一共9个
    private boolean judgeAllSubBox(){
        //有false直接短路
        return judgeSingleBox(0,0) &&
                judgeSingleBox(0,3) &&
                judgeSingleBox(0,6) &&
                judgeSingleBox(3,0) &&
                judgeSingleBox(3,3) &&
                judgeSingleBox(3,6) &&
                judgeSingleBox(6,0) &&
                judgeSingleBox(6,3) &&
                judgeSingleBox(6,6);

    }

    //判断所有单个子数独是否满足条件
    private boolean judgeSingleBox(int m,int n){
        Map<Integer, int[]> num = new HashMap<>(9);
        for (int i = m; i < m+3; i++) {
            for (int j = n; j < n+3; j++) {
                if (board[i][j] == '.'){continue;}
                if (num.containsKey(board[i][j]-'0')){
                    return false;
                }else {
                    num.put(board[i][j]-'0',new int[]{i,j});
                }
            }
        }
        return true;
    }
}
