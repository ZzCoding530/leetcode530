package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/3
 * @description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */

public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1Char[i--] - '0';
            int y = j < 0 ? 0 : num2Char[j--] - '0';
            int sum = x + y + carry;
            //添加到字符串尾部
            s.append(sum % 10);
            carry = sum / 10;
        }
        //对字符串反转
        return s.reverse().toString();
    }



}
