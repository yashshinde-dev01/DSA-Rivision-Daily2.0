
class Solution {
    class Pair {
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.effort, b.effort)
        );

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int row = curr.row;
            int col = curr.col;
            int effort = curr.effort;

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            if (effort > dist[row][col]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int diff = Math.abs(
                        heights[row][col] - heights[nr][nc]
                    );

                    int newEffort = Math.max(effort, diff);

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}
