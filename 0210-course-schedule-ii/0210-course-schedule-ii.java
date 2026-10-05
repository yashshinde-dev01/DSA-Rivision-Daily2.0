class Solution {
    Queue<Integer>q=new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>temp=new ArrayList<>();
         int n=numCourses;
         int[]ans=new int[n];
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
            temp.add(node);        
            for(int v:graph.get(node)){
                indeg[v]--;
                if(indeg[v]==0){
                    q.offer(v);
                }
            }
        }

        if(temp.size()==n){
           for(int i=0;i<temp.size();i++){
            ans[i]=temp.get(i);
           }
           return ans;
        }
        return new int[]{};
    }
}