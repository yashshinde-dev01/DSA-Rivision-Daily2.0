class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        
        for(int num:nums){
            total+=num;
        }
        if(total%2!=0){
            return false;
        }
        int target=total/2;
        int[][]dp=new int[nums.length][target+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,target,dp);
    }
    boolean solve(int[]nums,int idx,int target,int[][]dp){
        if(nums[idx]==target)return true;
        if(idx==nums.length-1){
            return nums[nums.length-1]==target;
        }
        if(dp[idx][target]!=-1)return dp[idx][target]==1;
        boolean no_take=solve(nums,idx+1,target,dp);
        boolean take=false;
        if(target>nums[idx]){
            take=solve(nums,idx+1,target-nums[idx],dp);
        }
        dp[idx][target]=(no_take || take)? 1:0;
        return dp[idx][target]==1;
    }
}