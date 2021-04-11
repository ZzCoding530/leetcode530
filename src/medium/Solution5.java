package medium;

/**
 * @author: zhangchen
 * @date: 2021/4/11
 * @description: 最长回文子串
 * <p>
 * !!!!!!!!!这道题背也要背下来！！！！！！！
 */

public class Solution5 {
    public String longestPalindrome(String s) {
        int strLen = s.length();

        //如果长度是0那就返回本身就是null  如果长度是1，自身也是回文
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
