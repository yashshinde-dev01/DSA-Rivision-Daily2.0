class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[]dp=new int[366];
        Arrays.fill(dp,-1);

        return solve(days,costs,0,dp);
        
    }
    public int solve(int[]days,int[]costs,int idx,int[]dp){
        int n=days.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];
        int cost_1=costs[0]+solve(days,costs,idx+1,dp);  

        int max_day=days[idx]+7;
        int j=idx;
        while(j<n && days[j]<max_day){
            j++;
        }
        int cost_2=costs[1]+solve(days,costs,j,dp);



        j=idx;
        int max_day2=days[idx]+30;
        while(j<n && days[j]<max_day2){
            j++;
        }
        int cost_3=costs[2]+solve(days,costs,j,dp); 


        int min=Math.min(cost_1,Math.min(cost_2,cost_3));

       
        return dp[idx]=min;
    }
}