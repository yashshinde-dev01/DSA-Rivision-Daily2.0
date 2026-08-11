class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[]leftprefix=new int[n];
        int[]rightprefix=new int[n];
        leftprefix[0]=nums[0];
        rightprefix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            leftprefix[i]=leftprefix[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            rightprefix[i]=rightprefix[i+1]+nums[i];
        }
        for(int i=0;i<n;i++){
            int total=rightprefix[i]-leftprefix[i];
            if(total==0){
                return i;
            }
        }
        return -1;
    }
}