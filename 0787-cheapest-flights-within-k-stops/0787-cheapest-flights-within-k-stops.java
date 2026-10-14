
class Solution {
    class pair {
        int node;
        int wt;
        int stops;

        pair(int node, int wt, int stops) {
            this.node = node;
            this.wt = wt;
            this.stops = stops;
        }
    }

    class pair2 {
        int node;
        int wt;

        pair2(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int findCheapestPrice(
        int n, int[][] flights, int src, int dst, int k
    ) {
        ArrayList<List<pair2>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            adj.get(u).add(new pair2(v, wt));
        }

        Queue<pair> que = new LinkedList<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        que.offer(new pair(src, 0, 0));

        while (!que.isEmpty()) {
            pair top = que.poll();

            int node = top.node;
            int cost = top.wt;
            int stops = top.stops;

            // At most k stops means at most k + 1 flights
            if (stops == k + 1) {
                continue;
            }

            for (pair2 neb : adj.get(node)) {
                int next = neb.node;
                int price = neb.wt;

                int newCost = cost + price;

                if (newCost < dist[next]) {
                    dist[next] = newCost;

                    que.offer(
                        new pair(next, newCost, stops + 1)
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
            ? -1
            : dist[dst];
    }
}
