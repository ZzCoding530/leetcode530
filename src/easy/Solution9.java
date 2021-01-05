package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/5
 * @description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */

class Solution9 {
    public boolean isPalindrome(int x) {

        String num = String.valueOf(x);

        if (num.length() == 1) {
            return true;
        }


        int l = 0;
        int r = num.length() - 1;

        while (l <= r && num.charAt(l) == num.charAt(r)) {
            l++;
            r--;
        }

        return l > r;
    }


    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean palindrome = solution9.isPalindrome(2552552);
        System.out.println(palindrome);
    }
}
