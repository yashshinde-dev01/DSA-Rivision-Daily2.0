class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=piles[0];
        for(int i=0;i<n;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int l=1;
        int r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            int hr=kokoeat(piles,mid);
            if(hr<=h){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    static int kokoeat(int[]nums,int k){
        int speed=0;
        for(int i=0;i<nums.length;i++){
            speed+=Math.ceil(nums[i]+k-1)/k;
        }
        return speed;
    }
}