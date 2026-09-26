class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[]visited=new boolean[n];
        dfs(0,visited,rooms);
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                return false;
            }
        }
        return true;
        
    }
    void dfs(int node,boolean[]vis,List<List<Integer>> rooms){
        vis[node]=true;

        for(int val:rooms.get(node)){
            if(!vis[val]){
                dfs(val,vis,rooms);
            }
        }
    }
}