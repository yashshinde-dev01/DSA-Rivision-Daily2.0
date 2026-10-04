class Solution {
    // 1--for red color
    // 0---blue color
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]color=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
             if(color[i]==-1){
                if(DFS(graph,i,color,1)==false){
                return false;
             }
             }
        }
        return true;
    }
    boolean DFS(int[][]graph,int curr,int[]color,int currColor){
        int n=graph.length;
        color[curr]=currColor;

        for(int v:graph[curr]){
            if(color[v]==color[curr])return false;
            if(color[v]==-1){
                int newColor=1-currColor;
                if(DFS(graph,v,color,newColor)==false){
                    return false;
                }
            }
        }
        return true;
    }
}