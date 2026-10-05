class Solution {
    Queue<Integer>q=new LinkedList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[]mini:prerequisites){
            int one=mini[1];
            int two=mini[0];

            graph.get(one).add(two);
        }

        int[]indeg=new int[n];

        for(int i=0;i<n;i++){
            for(int v:graph.get(i)){
                indeg[v]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;

            for(int v:graph.get(node)){
                indeg[v]--;
                if(indeg[v]==0){
                    q.offer(v);
                }
            }
        }
        if(cnt==n){
            return true;
        }
        return false;
    }
}