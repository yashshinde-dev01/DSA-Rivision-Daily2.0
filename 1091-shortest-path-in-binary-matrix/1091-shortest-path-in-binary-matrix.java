class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       if(grid[0][0]!=0 || grid[m-1][n-1]!=0){
        return -1;
       }

       int[][]directions={{0,-1},{0,1},{-1,0},{1,0},
       {1,-1},{-1,1},{-1,-1},{1,1}} ;

       int path=0;
       Queue<int[]>q=new LinkedList<>();
       q.add(new int[]{0,0});
       grid[0][0]=1;

       while(!q.isEmpty()){
        int size=q.size();
        for(int k=0;k<size;k++){
            int[]cell=q.poll();

        int i=cell[0];
        int j=cell[1];

        if(i==m-1 &&  j==n-1){
            return path+1;
        }

        for(int[]dir:directions){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            

             if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 0) {
                    q.add(new int[] {new_i, new_j});
                    grid[new_i][new_j]=1;
                }
        }
        }
        path++;
       }
       return -1;
       
    }
}