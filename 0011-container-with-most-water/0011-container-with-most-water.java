class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
       int l=0;
       int r=n-1;
       int ans=0;
       while(l<r){
        int wd=r-l;
        int ht=Math.min(height[l],height[r]);
        ans=Math.max(ans,wd*ht);

        if(height[l]<height[r]){
            l++;
        }else{
            r--;
        }
       }
       return ans;

    }
}