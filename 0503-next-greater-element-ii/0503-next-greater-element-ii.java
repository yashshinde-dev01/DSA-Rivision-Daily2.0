class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            int j=(i+1)%n;
            while(j!=i){
                if(nums[j]>nums[i]){
                    ans[i]=nums[j];
                    break;
                }
                j=(j+1)%n;
            }
        }
        return ans; 
    }
}