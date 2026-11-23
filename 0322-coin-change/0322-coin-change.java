class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int ans=solve(coins,amount,n-1,dp);

        return ans==Integer.MAX_VALUE ? -1:ans;
    }
    public int solve(int[]arr,int target,int idx,int[][]dp){
        if(idx==0){
            if(target%arr[idx]==0){
                return target/arr[idx];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[idx][target]!=-1)return dp[idx][target];
        int not_take=solve(arr,target,idx-1,dp);
        int take=Integer.MAX_VALUE;
        if(arr[idx]<=target){
            take=solve(arr,target-arr[idx],idx,dp);
        }
        if(take!=Integer.MAX_VALUE){
            take=1+take;
        }
        return dp[idx][target] =Math.min(not_take,take);
    }
} 