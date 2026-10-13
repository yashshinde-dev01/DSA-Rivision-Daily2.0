class Solution {
    class pair{
        int node;
        int wt;
        pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:times){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            adj.get(u).add(new pair(v,wt));
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new pair(k,0));
        int[]ans=new int[n+1];
        
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;

        while(!pq.isEmpty()){
            pair top=pq.poll();
            int d=top.wt;
            int node=top.node;
            for(pair val:adj.get(node)){
                int neb=val.node;
                int weight=val.wt;

                if(d+weight<ans[neb]){
                    ans[neb]=d+weight;

                    pq.offer(new pair(neb, d+weight));
                }
            }
        }
        int res=0;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                return -1;
            }
            res=Math.max(res,ans[i]);
        }
        return res;
    }
}