class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer>dp=new ArrayList<>();
        for(int i=0;i<=n;i++){
            dp.add(0);
        }
        return stairs(n,dp);

    }
    int stairs(int n,ArrayList<Integer>dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp.get(n)!=0)return dp.get(n);
        int ans=stairs(n-1,dp)+stairs(n-2,dp);
        dp.set(n,ans);
        return ans;
    }
}