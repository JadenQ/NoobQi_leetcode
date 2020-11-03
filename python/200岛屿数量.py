class Solution(object):
    def dfs(self, grid, r, c):
        #设置该位置为0
        grid[r][c] = 0
        m = len(grid)
        n = len(grid[0])
        #搜索四周
        for x, y in [(r-1, c), (r+1, c), (r, c-1), (r, c+1)]:
            if 0<= x < m and 0<= y < n and grid[x][y] == "1":
                self.dfs(grid, x, y) #递归

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        count = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    count += 1
                    self.dfs(grid, r, c)
        return count