class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[]vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
           if(vis[i]==false){
            bfs(i,vis,isConnected);
            ans++;
           } 
        }
        return ans;
    }
     void bfs(int node, boolean[] vis, int[][] graph){
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        vis[node] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int j = 0; j < graph.length; j++){
                if(graph[curr][j] == 1 && !vis[j]){
                    vis[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}