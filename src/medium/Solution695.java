package medium;

/**
 * @author: zhangchen
 * @date: 2021/3/21
 * @description: 岛屿最大面积
 */

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int tempArea = islandArea(grid, row, col);
                    res = Math.max(tempArea, res);
                }

            }

        }

        return res;
    }


    private int islandArea(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }


        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = 2;

        return 1
                + islandArea(grid, row + 1, col)
                + islandArea(grid, row - 1, col)
                + islandArea(grid, row, col + 1)
                + islandArea(grid, row, col - 1);
    }
}
