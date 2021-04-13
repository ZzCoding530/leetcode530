package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangchen
 * @date: 2021/4/12
 * @description: 电话号码的字母组合
 */

public class Solution17 {
    public List<String> letterCombinations(String digits) {

        //新建一个list作为返回结果
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        //存一下各个键位的对应关系
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // 回溯算法
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());

        return combinations;
    }


    /**
     * 回溯  跟全排列那道题差不多
     *
     * @param combinations 用来存结果的
     * @param phoneMap     对应关系
     * @param digits       输入按键
     * @param index        0开始
     * @param combination  用来暂时存的
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
