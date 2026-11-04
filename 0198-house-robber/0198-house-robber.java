class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // int[]dp=new int[n];
        // Arrays.fill(dp,-1);
        // return solve(nums,0,dp);
        int prev2=0;
        int prev=nums[0];
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>1)take+=prev2;
            int notake=prev;

            int curr=Math.max(take,notake);

            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    // int solve(int[]nums,int i,int[]dp){
    //     if(i>=nums.length){
    //         return 0;
    //     }
    //    if(dp[i]!=-1)return dp[i];

    //     int rob=nums[i]+solve(nums,i+2,dp);

    //     int skip=solve(nums,i+1,dp);
    //     return dp[i]=Math.max(skip,rob);
    // }
}