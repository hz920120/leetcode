package com.cn.sep2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-26 10:05:43
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class GetSum_371 {

    public int getSum(int a, int b) {
        int bnrA = 0;
        int bnrB = 0;

        int i = 0;
        while (a>>>i != 0) {
            bnrA = (((a >>> i) & 1) | bnrA) << i++;
        }

        i = 0;
        while (b>>>i != 0) {
            bnrB = (((b >>> i) & 1) | bnrB) << i++;
        }

        boolean carrier = false;
        i = 0;
        int res = 0;
        while (bnrA != 0 || bnrB != 0) {
            int ca = bnrA >>> i;
            int cb = bnrB >>> i;
            int cRes;
            if (ca == 1 && cb == 1) {
                if (carrier) {
                    cRes = 1;
                } else {
                    cRes = 0;
                    carrier = true;
                }
            } else {
                cRes = ca ^ cb;
                if (cRes == 1) {
                    if (carrier) cRes = 0;
                } else {
                    if (carrier) {
                        cRes = 1;
                        carrier = false;
                    }
                }
            }
            bnrA >>>= i;
            bnrB >>>= i;
            res = ((res ^ cRes) << i);
        }

//        while (res)
        return 0;
    }


    public static void main(String[] args) {
        GetSum_371 getSum = new GetSum_371();
        getSum.getSum(2,3);
    }

}
