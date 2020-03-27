/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200326_question_999;

/**
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 *
 * Return the number of pawns the rook can capture in one move.
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月26日 9:58 上午 huangzuo Exp $
 */
public class Solution {
    public int numRookCaptures(char[][] board) {

        int x = -1;
        int y = -1;

        a:for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R'){
//                    System.out.println(board[i][j]);
                    x = i;
                    y = j;
                    break a;
                }
            }
        }
        if (x == -1 || y ==-1){
            return 0;
        }

        int res = 0;


        l:for (int i = 0; i < y; i++) {
            if (board[i][y] == 'p') {
                int left = i;
                int right = x;
                boolean noBishop = true;
                for (int m = left + 1; m < right; m++) {
                    if (board[m][y] == 'B') {
                        noBishop = false;
                    }
                }
                if (noBishop) {
                    res += 1;
                    break l;
                }
            }
        }
        r:for (int i = y; i <8 ; i++) {
            if (board[i][y] == 'p') {
                int left = x;
                int right = i;
                boolean noBishop = true;
                for (int m = left + 1; m < right; m++) {
                    if (board[m][y] == 'B') {
                        noBishop = false;
                    }
                }
                if (noBishop) {
                    res += 1;
                    break r;
                }
            }
        }
        d:for (int i = 0; i < x; i++) {
            if (board[x][i] == 'p'){
                int left = i;
                int right = y;
                boolean noBishop = true;
                for (int m = left +1;m<right;m++){
                    if (board[x][m] == 'B'){
                        noBishop = false;
                    }
                }
                if (noBishop){
                    res += 1;
                    break d;
                }
            }
        }
        u:for (int i = x; i < 8; i++) {
            if (board[x][i] == 'p'){
                int left = y;
                int right = i;
                boolean noBishop = true;
                for (int m = left +1;m<right;m++){
                    if (board[x][m] == 'B'){
                        noBishop = false;
                    }
                }
                if (noBishop){
                    res += 1;
                    break u;
                }
            }
        }
//        boolean n = true;
//        boolean s = true;
//        boolean w = true;
//        boolean e = true;
//        b:for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j] == 'p'){
//                    int left = -1;
//                    int right = -1;
//                    if (x == i){
//                        left = y > j ? j : y;
//                        right = y < j ? j : y;
//                        boolean noBishop = true;
//                        for (int m = left +1;m<right;m++){
//                            if (board[x][m] == 'B'){
//                                noBishop = false;
//                            }
//                        }
//                        if (noBishop){
//                            res += 1;
//                        }
//                    }
//
//                    if (y == j){
//                        left = x > i ? i : x;
//                        right = x < i ? i : x;
//                        boolean noBishop = true;
//                        for (int m = left +1;m<right;m++){
//                            if (board[m][y] == 'B'){
//                                noBishop = false;
//                            }
//                        }
//                        if (noBishop){
//                            res += 1;
//                        }
//                    }
//                }
//            }
//        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chars[i][j] = '.';
            }
        }
        chars[3][5]='R';
        chars[3][2]='p';
        chars[3][6]='p';
        chars[7][5]='p';

        System.out.println(solution.numRookCaptures(chars));

    }
}
