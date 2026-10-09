class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int v=edges.length;
        int[]parent=new int[v+1];
        int[]rank=new int[v+1];
        ArrayList<int[]>ans=new ArrayList<>();
        for(int i=1;i<=v;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[]edge:edges){
            int ed1=edge[0];
            int ed2=edge[1];
            boolean f1=union(ed1,ed2,parent,rank);
            if(f1){
               return new int[]{ed1,ed2};
            }
        } 
        
        return new int[]{};
    }
    boolean union(int x,int y,int[]parent,int[]rank){
        int parent_x=find(x,parent);
        int parent_y=find(y,parent);
        if(parent_x==parent_y){
            return true;
        }
        if(rank[parent_x]>rank[parent_y]){
            parent[parent_y]=parent_x;
        }else if(rank[parent_x]<rank[parent_y]){
            parent[parent_x]=parent_y;
        }else{
            parent[parent_y]=parent_x;
            rank[parent_x]++;
        }
        return false;
    }
    int find(int node,int[]parent){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=find(parent[node],parent);
    }
}