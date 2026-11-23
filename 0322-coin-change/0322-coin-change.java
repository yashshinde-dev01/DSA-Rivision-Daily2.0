class Solution {
    public int coinChange(int[] coins, int amount) {
        int target=amount;
        int n=coins.length;
        int[][]dp=new int[n][target+1];
        for(int t=0;t<=target;t++){
            if(t%coins[0]==0){
                dp[0][t]= t/coins[0];
            }else{
                dp[0][t]= Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=target;t++){
                int not_take=dp[i-1][t];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=t){
                    take=dp[i][t-coins[i]];
                }
                if(take!=Integer.MAX_VALUE){
                    take=1+take;
                }
                dp[i][t]=Math.min(take,not_take);
            }
        }
        return dp[n-1][target] == Integer.MAX_VALUE
       ? -1
       : dp[n-1][target];
    }
    // public int solve(int[]arr,int target,int idx,int[][]dp){
    //     if(idx==0){
    //         if(target%arr[idx]==0){
    //             return target/arr[idx];
    //         }else{
    //             return Integer.MAX_VALUE;
    //         }
    //     }
    //     if(dp[idx][target]!=-1)return dp[idx][target];
    //     int not_take=solve(arr,target,idx-1,dp);
    //     int take=Integer.MAX_VALUE;
    //     if(arr[idx]<=target){
    //         take=solve(arr,target-arr[idx],idx,dp);
    //     }
    //     if(take!=Integer.MAX_VALUE){
    //         take=1+take;
    //     }
    //     return dp[idx][target] =Math.min(not_take,take);
    // }
} 