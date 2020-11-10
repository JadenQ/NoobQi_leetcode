class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        //List<List<Integer>> queue = new ArrayList<List<Integer>>();
        int N = grid.length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[] {i, j});
                }
            }
        }
        if(queue.isEmpty() || queue.size() == N*N){
            return -1;
        }
        int distance = -1;
        while(queue.isEmpty() == false){
            int n = queue.size();
            distance++;
            for(int k = 0; k < n; k++){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                if(r - 1 >= 0 && grid[r - 1][c] == 0){
                    grid[r - 1][c] = 2;
                    queue.add(new int[] {r - 1, c});
                }
                if(r + 1 < N && grid[r + 1][c] == 0){
                    grid[r + 1][c] = 2;
                    queue.add(new int[] {r + 1, c});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 0){
                    grid[r][c - 1] = 2;
                    queue.add(new int[] {r, c - 1});
                }
                if(c + 1 < N && grid[r][c + 1] == 0){
                    grid[r][c + 1] = 2;
                    queue.add(new int[] {r, c + 1});
                }
            }
        }
        return distance;

    }
}