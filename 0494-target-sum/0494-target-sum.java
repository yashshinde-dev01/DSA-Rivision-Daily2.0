class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        int max=0;
        for(int val:nums){
            max+=val;
        }
        int size=max*2+1;
        
        int[][]dp=new int[nums.length][size];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        
       return solve(nums,target,total,nums.length-1,dp,max); 
    }
    public int solve(int[]arr,int target,int total,int idx,int[][]dp,int max){
        if(idx<0){
            if(total==target){
                return 1;
            }
            return 0;
        }
        int temp=total+max;
        if(dp[idx][temp]!=-1)return dp[idx][temp];
        
        int posi=solve(arr,target,total+arr[idx],idx-1,dp,max);
        int negi=solve(arr,target,total-arr[idx],idx-1,dp,max);
        return dp[idx][temp]=posi+negi;
    }
}