class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(coins,amount,coins.length-1,dp);
    }
    public int solve(int[]arr,int amount,int idx,int[][]dp){
        if(idx==0){
            if(amount%arr[idx]==0){
                return 1;
            }
            return 0;
        }
        if(amount==0)return 1;
        if(dp[idx][amount]!=-1)return dp[idx][amount];

        int not_take=solve(arr,amount,idx-1,dp);
        int take=0;
        if(amount-arr[idx]>=0){
            take=solve(arr,amount-arr[idx],idx,dp);
        }
        return dp[idx][amount]=take+not_take;
    }
}