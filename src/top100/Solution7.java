package top100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 判断有效括号
 */

public class Solution7 {

    /**
     * 一个左括号对应一个右括号，用栈啊很显然，半个就压进去，有另一半就弹出去，没有另一半就弹不出去，最后栈不空就是有一半的括号
     * 而且括号得是按顺序的，先左再右，并且连续的，所以不合法的可能性如下
     * 1）如果我们拿着右括号，发现栈是空的，没有左括号可匹配，那就不合法
     * 2）我们拿着右括号，发现栈顶的不是对应的左括号，那就说明这个右括号的前一位和当前右括号不匹配
     *
     * @param s 给的字符串
     * @return 括号是否都有效？？？
     */
    public boolean isValid(String s) {

        //奇数的必不对
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {

                //      栈空了      或者  栈顶元素和下一个元素括号不匹配
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }

                //能匹配上那就把栈顶元素出栈
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
