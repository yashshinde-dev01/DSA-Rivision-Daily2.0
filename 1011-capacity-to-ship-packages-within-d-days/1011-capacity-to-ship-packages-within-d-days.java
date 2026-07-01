class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int max=0,sum=0;
       for(int val:weights){
        max=Math.max(val,max);
        sum+=val;
       } 
       int l=max;
       int r=sum;
    //    int ans=max;
       while(l<=r){
        int mid=l+(r-l)/2;
        if(CanShip(weights, days,mid)){
            // ans=mid;
            r=mid-1;
        }else{
            l=mid+1;
        }
       }
       return l;
    }
    private static boolean CanShip(int[]nums,int days,int cap){
        int day=1;
        int curr=0;
        for(int w:nums){
            if(curr+w>cap){
                day++;
                curr=w;
            }else{
                curr+=w;
            }
        }
        if(day<=days){
            return true;
        }else{
            return false;
        }
    }
}