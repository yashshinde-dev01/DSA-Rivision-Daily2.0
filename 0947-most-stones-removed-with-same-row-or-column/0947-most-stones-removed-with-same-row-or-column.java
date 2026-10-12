class Solution {
    public int removeStones(int[][] stones) {
      int n=stones.length;
      int groups=0;
      boolean[]visi=new boolean[n];
      for(int i=0;i<n;i++){
        if(!visi[i]){
            DFS(i,visi,stones);
            groups++;
        }
      } 
      return n-groups;  
    }
    void DFS(int node,boolean[]visi,int[][]stones){
        visi[node]=true;

        for(int i=0;i<visi.length;i++){
            int r=stones[node][0];
            int c=stones[node][1];
            if((!visi[i]) && (stones[i][0]==r || stones[i][1]==c)){
                DFS(i,visi,stones);
            }
        }
    }
}