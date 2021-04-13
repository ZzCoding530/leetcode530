package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhangchen
 * @date: 2021/4/13
 * @description: 翻转字符串里的单词
 */

public class Solution151 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());

                // 把StringBuilder置空
                word.setLength(0);

            }
            //如果遍历到的是字母 那就word加进去
            else if (c != ' ') {
                word.append(c);
            }
            left++;
        }

        //因为刚才把结尾的空格都删除了 所以最后的一个单词，需要手动添加到双端队列里
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}
