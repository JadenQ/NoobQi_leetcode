class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        N = len(grid)
        queue = []
        # 所有陆地加入队列
        for i in range(N):
            for j in range(N):
                if grid[i][j] == 1:
                    queue.append((i, j))
        # 如果地图上之有陆地/海洋，返回-1
        if len(queue) == 0 or len(queue) == N * N:
            return -1
        distance = -1
        while len(queue) > 0:
            distance += 1
            land = len(queue)
            for i in range(land):
                r, c = queue.pop(0)
                if r - 1 >= 0 and grid[r - 1][c] == 0:
                    # 标记已经走过
                    grid[r - 1][c] = 2
                    queue.append((r - 1, c))      
                if r + 1 < N and grid[r + 1][c] == 0:
                    grid[r + 1][c] = 2
                    queue.append((r + 1, c))
                if c - 1 >= 0 and grid[r][c - 1] == 0:
                    grid[r][c - 1] = 2
                    queue.append((r, c - 1))
                if c + 1 < N and grid[r][c + 1] == 0:
                    grid[r][c + 1] = 2
                    queue.append((r, c + 1))
        return distance