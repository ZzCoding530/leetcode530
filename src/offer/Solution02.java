package offer;


/**
 * @author: zhangchen
 * @date: 2021/1/27
 * @description:
 */

public class Solution02 {
    public String replaceSpace(StringBuffer str) {

        while (str.indexOf(" ") >= 0) {
            int indexOfSpace = str.indexOf(" ");
            str.replace(indexOfSpace, indexOfSpace + 1, "%20");
        }


        return str.toString();
    }
}
