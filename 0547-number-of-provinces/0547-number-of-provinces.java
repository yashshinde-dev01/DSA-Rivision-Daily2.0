class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[]vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
           if(vis[i]==false){
            dfs(i,vis,isConnected);
            ans++;
           } 
        }
        return ans;
    }
    void dfs(int node,boolean[]vis,int[][]graph){
        vis[node]=true;

        for(int j=0;j<graph.length;j++){
            if(graph[node][j]==1 && vis[j]==false){
                dfs(j,vis,graph);
            }
        }
    }
}