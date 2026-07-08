// Time complexity: O(m * n * log(m * n))
// Space complexity: O(m * n)
class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        if (grid[0][1] > 1 || grid[1][0] > 1) return -1;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        
        pq.offer(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], time = curr[2];
            if (x == m - 1 && y == n - 1) return time;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                int nextTime = Math.max(time + 1, grid[nx][ny]);
                pq.offer(new int[] {nx, ny, nextTime});
            }
        }
        
        return -1;
    }
}