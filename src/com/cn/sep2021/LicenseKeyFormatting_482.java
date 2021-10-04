package com.cn.sep2021;

import java.util.Locale;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-04 10:24:42
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class LicenseKeyFormatting_482 {

    public String licenseKeyFormatting(String s, int k) {
        if (s.equals("")) {
            return s;
        }

        if (s.length() <= k) {
            return s.replace("-","").toUpperCase();
        }

        s = s.replace("-","").toUpperCase();
        int first = s.length() % (k);

        StringBuilder sb = new StringBuilder();
        if (first != 0) {
            sb.append(s, 0, first).append("-");
            s = s.substring(first);
        }
        int index = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i != 0 && (i % k == 0)){
                sb.append(s, index, i);
                if (i != s.length()) sb.append("-");
                index = i;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting_482 licenseKeyFormatting_482 = new LicenseKeyFormatting_482();
        System.out.println(licenseKeyFormatting_482.licenseKeyFormatting("2-5g-3-J", 2));
    }

}
