package offer;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description:
 */

public class Solution48 {

//        public int lengthOfLongestSubstring(String s) {
//            //用来判断重复的set
//            Set<Character> set = new HashSet<>();
//
//            //左指针 右指针 结果
//            int left = 0, right = 0, res = 0;
//
//            //遍历字符
//            while(right < s.length()){
//                char c = s.charAt(right++);
//                //存在重复的字符，则移动左指针，直到滑动窗口中不含有该字符
//                while(set.contains(c)){
//                    set.remove(s.charAt(left++));
//                }
//                set.add(c);
//                res = Math.max(res, right-left);
//            }
//            return res;
//        }

    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(new Solution48().lengthOfLongestSubstring(test));
    }


    public int lengthOfLongestSubstring(String s) {

        int ans = 0;
        //       字符      出现的index
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        int left = 0;
        for (int i = 0; i < s.length(); i++) {

            if (hashMap.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - left);
                left = i;
                hashMap.put(s.charAt(i), i);
            }
            hashMap.put(s.charAt(i), i);
            ans = Math.max(i - left + 1, ans);


        }

        if (hashMap.size() == s.length()) {
            return s.length();
        }

        return ans;

    }


}
