class Solution {
    ArrayList<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
       ArrayList<Integer>path=new ArrayList<>();
       dfs(graph,0,n-1,path); 
       return ans; 
    }
    void dfs(int[][]graph,int u,int target,ArrayList<Integer>path){
        path.add(u);
        if(u==target){
            ans.add(new ArrayList<>(path));
        }else{
            for(int neig:graph[u]){
                dfs(graph,neig,target,path);
            }
        }
        path.remove(path.size()-1);
    }
}