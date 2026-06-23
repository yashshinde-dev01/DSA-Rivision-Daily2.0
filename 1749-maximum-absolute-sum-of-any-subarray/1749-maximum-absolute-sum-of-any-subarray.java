class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=nums[0];
        int minsum=nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            maxsum=Math.max(nums[i],maxsum+nums[i]);
            minsum=Math.min(nums[i],nums[i]+minsum);

            max=Math.max(max,maxsum);
            min=Math.min(min,minsum);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}