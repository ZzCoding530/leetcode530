package offer;

/**
 * @author: zhangchen
 * @date: 2021/2/10
 * @description: 字符串转换成整数
 */

public class Solution67 {
    public int strToInt(String str) {
        //先去掉所有空格
        str = str.trim();
        if (str.length() == 0 || str.equals("+") || str.equals("-")) {
            return 0;
        }

        //为了应对反人类的"+-2"
        if (str.contains("+") && str.contains("-")) {
            int gap = str.indexOf("+") - str.indexOf("-");
            if (gap == 1 || gap == -1) {
                return 0;
            }
        }

        //去除所有的正号 留着没用
        int iindex = 0;
        while (iindex < str.length()) {
            if (str.charAt(iindex) != '+' && str.charAt(iindex) != '-' && Character.isDigit(str.charAt(iindex))) {
                break;
            } else if (str.charAt(iindex) == '+') {
                str = str.substring(iindex + 1);
            }
            iindex++;
        }


        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-') {
            return 0;
        }

        //该正经严肃地进行符号位计算了
        int sign = str.charAt(0) == '-' ? -1 : 1;
        //如果第一位是负号那就去掉负号先
        str = str.charAt(0) == '-' ? str.substring(1) : str;

        int index = 0;
        //求出是数字的字符串长度
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                index++;
            } else {
                break;
            }

        }
        str = str.substring(0, index);
        long result = 0;

        //然后把字符串转为数字吧 先用long存再判断
        for (int i = 0; i < str.length(); ++i) {
            result = result * 10 + (str.charAt(i) - '0');

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && result - 1 > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }

        //高端的转换往往只需要朴素的手法  之前做过判断了所以一定越界 强转就vans了
        return (int) (sign == 1 ? result : -result);
    }


    public static void main(String[] args) {
        int i = new Solution67().strToInt("+");
        System.out.println(i);
    }

}
