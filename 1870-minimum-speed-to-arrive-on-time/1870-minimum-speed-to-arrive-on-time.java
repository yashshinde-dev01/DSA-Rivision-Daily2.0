class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
       if(hour <= dist.length - 1) return -1;

        int l = 1, r = 10000000;
        int ans = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(CanReach(dist, hour, mid)){
                ans = mid;
                r = mid - 1; 
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    static boolean CanReach(int[]nums,double hr,double speed){
        double ans=0;
          for(int i = 0; i < nums.length; i++){
        if(i == nums.length - 1){
            ans += (double) nums[i] / speed;
        } else {
            ans += Math.ceil((double) nums[i] / speed);
        }
    }
        if(ans<=hr){
            return true;
        }else{
            return false;
        } 
    }
}