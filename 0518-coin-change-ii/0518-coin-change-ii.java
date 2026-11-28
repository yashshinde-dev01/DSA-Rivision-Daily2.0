class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length][amount+1];
        int last=coins[coins.length-1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0){
                dp[0][t]=1;
            }else{
                dp[0][t]=0;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int not_take=dp[i-1][j];
                int take=0;
                if(j-coins[i]>=0){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=take+not_take;
            }
        }
        return dp[coins.length-1][amount];
    }
    // public int solve(int[]arr,int amount,int idx,int[][]dp){
    //     if(idx==0){
    //         if(amount % arr[idx]==0){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(amount==0)return 1;
    //     if(dp[idx][amount]!=-1)return dp[idx][amount];

    //     int not_take=solve(arr,amount,idx-1,dp);
    //     int take=0;
    //     if(amount-arr[idx]>=0){
    //         take=solve(arr,amount-arr[idx],idx,dp);
    //     }
    //     return dp[idx][amount]=take+not_take;
    // }
}