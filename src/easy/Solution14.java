package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/5
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * 这题主要复习一下str.charAt()  str.substring()
 */

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        //特殊情况处理
        if (strs.length == 0) {
            return "";
        }


        //首先把答案设成第一个字符串
        String ans = strs[0];
        //然后从第二个开始跟第一个找
        for (int i = 1; i < strs.length; i++) {
            int j = 0;

            //判断两个字符串到哪为止一样的
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            //截取一样的字符串，要是空，那就直接返回答案为空了
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }

}
