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

        //dp[i][j]代表的是  从i到j的闭区间截取的子串是否是回文子串
        //是就是true 不是就false
        boolean[][] dp = new boolean[strLen][strLen];

        //i和j分别为子串的首尾，都是闭区间能取到的
        //当然是从 0到1这个子串开始了，两个循环如下
        for (int j = 1; j < strLen; j++) {
            for (int i = 0; i < j; i++) {


                //如果i和j的字符不想等，显然标为false
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                }
                //如果i和j字符相等，那么还需要分两种情况，
                //1.  如果字符串很短，比如只有两个字符，那他俩相等，是回文，
                //    如果只有一个，那也是
                //    所以 j-i<3 时候可以存为true
                //2.  如果 j-i>=3 那就是字符串长度大于等于4呗
                //    那就查一下，他包含住的内一层的子串是不是true
                //    内层是，整个就是，内层不是，整个也就不是了
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
