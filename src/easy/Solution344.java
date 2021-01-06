package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/6
 * @description: 反转字符串
 */

class Solution344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}