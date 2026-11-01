class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer>dp=new ArrayList<>();
        for(int i=0;i<=n;i++){
            dp.add(0);
        }
        dp.set(0,1);
        dp.set(1,1);
        return stairs(n,dp);

    }
    int stairs(int n,ArrayList<Integer>dp){
        for(int i=2;i<=n;i++){
            dp.set(i,dp.get(i-1)+dp.get(i-2));
        }
        return dp.get(n);
    }
}