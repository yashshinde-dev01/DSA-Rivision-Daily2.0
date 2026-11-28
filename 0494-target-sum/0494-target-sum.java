class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
       
       return solve(nums,target,total,nums.length-1); 
    }
    public int solve(int[]arr,int target,int total,int idx){
        if(idx<0){
            if(total==target){
                return 1;
            }
            return 0;
        }
        
        int posi=solve(arr,target,total+arr[idx],idx-1);
        int negi=solve(arr,target,total-arr[idx],idx-1);
        return posi+negi;
    }
}