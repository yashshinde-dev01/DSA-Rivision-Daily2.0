class Solution {
    class pair{
        int wt;
        int node;

        pair(int wt,int node){
            this.wt=wt;
            this.node=node;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int m=points.length;
        int n=points[0].length;
        ArrayList<List<pair>>adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int d=Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.get(i).add(new pair(d,j));
                adj.get(j).add(new pair(d,i));
            }
        }
        return PrimsAlgo(adj,m);
    }
    int PrimsAlgo(ArrayList<List<pair>>adj,int V){
        int sum=0;
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        boolean[]visi=new boolean[V];
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair val=pq.poll();

            int wt=val.wt;
            int node=val.node;

            if(visi[node]){
                continue;
            }
            visi[node]=true;
            sum+=wt;
            for(pair temp:adj.get(node)){
                if(!visi[temp.node]){
                    pq.add(new pair(temp.wt,temp.node));
                }
            }
        }
        return sum;
    }
}