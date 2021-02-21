package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/19
 * @description: 翻转字符串里的单词
 */

public class Solution151 {
    public String reverseWords(String s) {

        char[] charArr = s.toCharArray();
        List<Character> word = new LinkedList<>();
        Stack<List<Character>> stack = new Stack<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                stack.push(word);
                word.clear();
            }

            word.add(charArr[i]);

        }

        return null;


    }
}
