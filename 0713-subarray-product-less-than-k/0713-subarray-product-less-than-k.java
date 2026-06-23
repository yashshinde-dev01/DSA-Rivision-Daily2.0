class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int l=0;
        int r=0;
        int cnt=0;
        while(r<nums.length){
            prod*=nums[r];
            while(prod>=k && l<=r){
                prod=prod/nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}