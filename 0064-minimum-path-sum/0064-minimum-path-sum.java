class Solution {
    public int minPathSum(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int[][]dp=new int[m][n];
       for(int[]row:dp){
        Arrays.fill(row,-1);
       }
       return solve(0,0,m,n,grid,dp); 
    }
    int solve(int i,int j,int m,int n,int[][]grid,int[][]dp){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE; 
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=solve(i+1,j,m,n,grid,dp);
        int right=solve(i,j+1,m,n,grid,dp);
        int leftCost = down == Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : grid[i][j] + down;

        int rightCost = right == Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : grid[i][j] + right;


        return dp[i][j]=Math.min(leftCost,rightCost);
    }
}