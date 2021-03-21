package medium;

/**
 * @author: zhangchen
 * @date: 2021/3/21
 * @description: 岛屿数量
 */

public class Solution200 {

    public int numIslands(char[][] grid) {
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    disappearIsland(grid, row, col);
                }
            }
        }

        return res;
    }


    private void disappearIsland(char[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return;
        }

        char islandSign = '1';
        if (grid[row][col] != islandSign) {
            return;
        }

        grid[row][col] = '2';
        disappearIsland(grid, row - 1, col);
        disappearIsland(grid, row + 1, col);
        disappearIsland(grid, row, col + 1);
        disappearIsland(grid, row, col - 1);

    }


}
