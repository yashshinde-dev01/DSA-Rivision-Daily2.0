class Solution {
    class pair {
        int wt;
        int u;
        int v;

        pair(int wt,int u,int v){
            this.wt=wt;
            this.u=u;
            this.v=v;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int m=points.length;
        int n=points[0].length;
        ArrayList<pair>adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int d=Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.add(new pair(d,i,j));
            }
        }
        return krushkal(adj,m);
    }
    
    int krushkal(ArrayList<pair>adj,int V){
        int sum=0;
        int[]parent=new int[V];
        int[]rank=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        adj.sort((a,b)->Integer.compare(a.wt,b.wt));

        for(pair val:adj){
            int u=val.u;
            int v=val.v;

            int pu=find(u,parent);
            int pv=find(v,parent);

            if(pu!=pv){
                union(pu,pv,parent,rank);
                sum+=val.wt;
            }
        }
        return sum;
    }
    void union(int x,int y,int[]parent,int[]rank){
        int parent_x=find(x,parent);
        int parent_y=find(y,parent);
        if(parent_x==parent_y){
            return ;
        }
        if(rank[parent_x]>rank[parent_y]){
            parent[parent_y]=parent_x;
        }else if(rank[parent_x]<rank[parent_y]){
            parent[parent_x]=parent_y;
        }else{
            parent[parent_y]=parent_x;
            rank[parent_x]++;
        }
    }
    int find(int node,int[]parent){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=find(parent[node],parent);
    }
}