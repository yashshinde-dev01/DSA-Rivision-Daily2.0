class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(j>0){
                left=matrix[i][j]+dp[i-1][j-1];
                }
                if(j<n-1){
                right=matrix[i][j]+dp[i-1][j+1];
                }
                int up=matrix[i][j]+dp[i-1][j];
                dp[i][j]=Math.min(up,Math.min(left,right));
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini=Math.min(dp[n-1][j],mini);
        }
        return mini;
    }
}