package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/22
 * @description: 岛屿问题
 */

public class Solution23 {
    public int numIslands(char[][] grid) {

        int res = 0;

        //1。首先 横纵坐标依次一行一行扫过所有的格子
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfsArr(grid, row, col);
                }

            }

        }


        return res;


    }

//

    private void dfsArr(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';

        dfsArr(grid, row - 1, col);
        dfsArr(grid, row + 1, col);
        dfsArr(grid, row, col + 1);
        dfsArr(grid, row, col - 1);
    }

//    private void dfsTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        dfsTree(root.left);
//        dfsTree(root.right);
//    }
}
