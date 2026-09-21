class Solution {
    public int search(int[] nums, int target) {
        int sidx=0;
        int eidx=nums.length-1;
        return binarySearch(nums,target,sidx,eidx);
    }
    private int binarySearch(int[]nums,int target,int sidx,int eidx){
        if(eidx<sidx){
            return -1;
        }
        int mid=sidx+(eidx-sidx)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(target>nums[mid]){
            return  binarySearch(nums,target,mid+1,eidx);
        }else{
            return  binarySearch(nums,target,sidx,mid-1);
        }
    }
}