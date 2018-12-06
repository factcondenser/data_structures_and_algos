package mendelProblems;

/*
 * (m x n) grid
 * (0, 0) -> (m - 1, n - 1)
 *
 * O(mn) time, O(mn) space
 *
 * [1][1] [1] [1]
 * [1][2] [3] [4]
 * [1][3] [6][10]
 * [1][4][10][20]
 *
 */
public class NumPathsSoln {
    // using memoization
    public static int numPathsMemo(int m, int n) {
        if (m <= 0 || n <= 0) return -1;
        int[][] memo = new int[m][n];
        return numPathsMemoHelper(m - 1, n - 1, memo);
    }

    private static int numPathsMemoHelper(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 1;
        }
        if (memo[i][j] == 0) {
            memo[i][j] = numPathsMemoHelper(i - 1, j, memo) + numPathsMemoHelper(i, j - 1, memo);
        }
        return memo[i][j];
    }

    // using tabulation
    public static int numPathsTab(int m, int n) {
        int[][] tab = new int[m][n];
        for (int i = 0; i < m; i++) {
            tab[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            tab[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tab[i][j] = tab[i - 1][j] + tab[i][j - 1];
            }
        }
        return tab[m-1][n-1];
    }

    // with 'blocks'
    public static int numPathsWithBlocks(boolean[][] grid) { // grid[i][j] if cell (i, j) is blocked
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int[][] tab = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0])
                break; // this and all following cells in col 0 should be 0
            tab[i][0] = 1;
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j])
                break; // this and all following cells in row 0 should be 0
            tab[0][j] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                tab[i][j] = grid[i][j] ? 0 : tab[i - 1][j] + tab[i][j - 1];
            }
        }
        return tab[grid.length - 1][grid[0].length - 1];
    }
}