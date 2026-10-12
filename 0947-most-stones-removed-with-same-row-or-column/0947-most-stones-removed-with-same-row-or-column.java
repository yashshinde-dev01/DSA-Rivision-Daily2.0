
class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int[] parent = new int[n];
        int[] rank = new int[n];


        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {
                    union(i, j, parent, rank);
                }
            }
        }


        int group = 0;

        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i) {
                group++;
            }
        }

        return n - group;
    }

    int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    void union(int i, int j, int[] parent, int[] rank) {
        int p_x = find(i, parent);
        int p_y = find(j, parent);

        if (p_x == p_y) {
            return;
        }

        if (rank[p_x] > rank[p_y]) {
            parent[p_y] = p_x;
        } else if (rank[p_y] > rank[p_x]) {
            parent[p_x] = p_y;
        } else {
            parent[p_y] = p_x;
            rank[p_x]++;
        }
    }
}
