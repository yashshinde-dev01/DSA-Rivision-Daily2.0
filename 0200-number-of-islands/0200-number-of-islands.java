class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]directions={{-1,0},{1,0},{0,-1},{0,1}};
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(grid[i][j]=='1'){
                bfs(grid,i,j,directions);
                ans++;
              } 
            }
        }
        return ans;
    }
    void bfs(char[][]grid,int m,int n,int[][]directions){
        Queue<int[]>que=new LinkedList<>();
        que.offer(new int[]{m,n});
        grid[m][n]='0';
        while(!que.isEmpty()){
            int[]val=que.poll();
            int i=val[0];
            int j=val[1];
            for(int[]dir:directions){
                int new_i=i+dir[0];
                int new_j=j+dir[1];

                if(new_i>=0 && new_i<grid.length && new_j>=0 && new_j<grid[0].length && grid[new_i][new_j]=='1'){
                    que.offer(new int[]{new_i,new_j});
                    grid[new_i][new_j]='0';
                }
            }
        }
    }
}