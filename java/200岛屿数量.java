class Solution {
    public void dfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for(int r = 0; r < m; ++r){
            for(int c = 0; c < n; ++c){
                if(grid[r][c] == '1'){
                    count += 1;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }
}