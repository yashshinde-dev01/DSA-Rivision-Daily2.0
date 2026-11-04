class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        int try1=helper1(nums,0,n-1,dp);
        Arrays.fill(dp,-1);
        int try2=helper2(nums,1,n,dp);
        return Math.max(try1,try2);
    }
    int helper1(int[]nums,int i,int end,int[]dp){

        if(i>=end){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];

        int rob=nums[i]+helper1(nums,i+2,end,dp);

        int skip=helper1(nums,i+1,end,dp);

        return dp[i]=Math.max(rob,skip);
    }
    int helper2(int[]nums,int i,int end,int[]dp){

        if(i>=end){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];

        int rob=nums[i]+helper2(nums,i+2,end,dp);

        int skip=helper2(nums,i+1,end,dp);

        return dp[i]=Math.max(rob,skip);
    }
}