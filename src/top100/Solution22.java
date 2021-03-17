package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/17
 * @description: 5 最长回文子串
 */

public class Solution22 {
    public String longestPalindrome(String s) {
        int strLen = s.length();
        if (strLen < 2) {
            return s;
        }


        int longest = 1;
        int resultStart = 0;

        boolean[][] dp = new boolean[strLen][strLen];


        for (int j = 1; j < strLen; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }


                if (dp[i][j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    resultStart = i;
                }
            }


        }

        return s.substring(resultStart, resultStart + longest);
    }

}
