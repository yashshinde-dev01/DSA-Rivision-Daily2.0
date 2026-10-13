
import java.util.*;

class Solution {

    class Pair {
        int node;
        int mask;

        Pair(int node, int mask) {
            this.node = node;
            this.mask = mask;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        Queue<Pair> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        // Start BFS from every node
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);

            que.offer(new Pair(i, mask));
            visited[i][mask] = true;
        }

        // Mask representing all nodes visited
        int allVisited = (1 << n) - 1;

        int path = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            // Process one BFS level
            while (size-- > 0) {
                Pair curr = que.poll();

                int node = curr.node;
                int currMask = curr.mask;

                // All nodes have been visited
                if (currMask == allVisited) {
                    return path;
                }

                // Visit neighboring nodes
                for (int val : graph[node]) {
                    int nextMask = currMask | (1 << val);

                    if (!visited[val][nextMask]) {
                        visited[val][nextMask] = true;
                        que.offer(new Pair(val, nextMask));
                    }
                }
            }

            path++;
        }

        return -1;
    }
}
