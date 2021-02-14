package algorithm;


import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 二叉树的三序遍历
 */

public class TreePrint {

    /**
     * 首先把头节点放到栈中 ， 然后开始弹 ， 遵守以下规则
     * 1    从栈中弹出立即打印
     * 2    若有右节点 先压右节点
     * 3    若有左节点 压左节点
     *
     * @param root 根节点
     */
    public void prePrintTree(TreeNode root) {
        System.out.println("这是先序遍历，\"头-左-右\"的顺序：");

        //特殊情况判断    空的节点跳过
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            //准备工作做完了 ， 接下来按照刚才的三步走
            while (!stack.isEmpty()) {
                //1.弹出就打印
                TreeNode head = stack.pop();
                System.out.print(head.value + "-");

                //2.有右节点先压右
                if (head.right != null) {
                    stack.push(head.right);
                }
                //3.然后看看有没有左节点？
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }
}
