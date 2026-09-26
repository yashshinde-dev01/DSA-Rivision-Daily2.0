class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer>q=new LinkedList<>();
        boolean[]visited=new boolean[n];
        q.add(0);
        visited[0]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            for(int val:rooms.get(node)){
                if(!visited[val]){
                    visited[val]=true;
                    q.offer(val);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                return false;
            }
        }
        return true;
    }
}