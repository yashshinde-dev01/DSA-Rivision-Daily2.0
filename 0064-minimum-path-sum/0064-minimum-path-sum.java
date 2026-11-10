class Solution {
    public int minPathSum(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int[][]dp=new int[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 && j==0){
                dp[i][j]=grid[i][j];
            }else{
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0){
                    up=grid[i][j]+dp[i-1][j];
                }
                if(j>0){
                    left=grid[i][j]+dp[i][j-1];
                }

                dp[i][j]=Math.min(left,up);
            }
        }

       }
       return dp[m-1][n-1];
    }
   
}
// memorization
//  int solve(int i,int j,int m,int n,int[][]grid,int[][]dp){
    //     if(i>=m || j>=n){
    //         return Integer.MAX_VALUE; 
    //     }
    //     if(i==m-1 && j==n-1){
    //         return grid[i][j];
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int down=solve(i+1,j,m,n,grid,dp);
    //     int right=solve(i,j+1,m,n,grid,dp);
    //     int leftCost = down == Integer.MAX_VALUE
    //             ? Integer.MAX_VALUE
    //             : grid[i][j] + down;

    //     int rightCost = right == Integer.MAX_VALUE
    //             ? Integer.MAX_VALUE
    //             : grid[i][j] + right;


    //     return dp[i][j]=Math.min(leftCost,rightCost);
    // }