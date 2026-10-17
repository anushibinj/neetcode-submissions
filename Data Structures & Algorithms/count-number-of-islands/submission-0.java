class Solution {
    private static final int[] x = new int[] { 0, 0, -1, 1 };
    private static final int[] y = new int[] { -1, +1, 0, 0 };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        // counting connected components!
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || 
                col < 0 || col >= grid[0].length)
            return;

        if (grid[row][col] != '1')
            return;

        grid[row][col] = '0';

        for (int i = 0; i < 4; i++) {
            dfs(grid, row + x[i], col + y[i]);
        }
    }
}