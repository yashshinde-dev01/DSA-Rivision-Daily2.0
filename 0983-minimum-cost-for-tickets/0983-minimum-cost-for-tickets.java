class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int lstday=days[n-1];
        HashSet<Integer>set=new HashSet<>();
        for(int val:days){
            set.add(val);
        }
        int[]dp=new int[lstday+1];
        dp[0]=0;

        for(int i=1;i<=lstday;i++){
            if(!set.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }
            dp[i]=Integer.MAX_VALUE;
            int day_1=costs[0]+dp[Math.max(i-1,0)];

            int day_7=costs[1]+dp[Math.max(0,i-7)];

            int day_30=costs[2]+dp[Math.max(0,i-30)];
            
            dp[i]=Math.min(day_1,Math.min(day_7,day_30));
        }
        return dp[lstday];
        
    }
    // public int solve(int[]days,int[]costs,int idx,int[]dp){
    //     int n=days.length;
    //     if(idx>=n){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1)return dp[idx];
    //     int cost_1=costs[0]+solve(days,costs,idx+1,dp);  

    //     int max_day=days[idx]+7;
    //     int j=idx;
    //     while(j<n && days[j]<max_day){
    //         j++;
    //     }
    //     int cost_2=costs[1]+solve(days,costs,j,dp);



    //     j=idx;
    //     int max_day2=days[idx]+30;
    //     while(j<n && days[j]<max_day2){
    //         j++;
    //     }
    //     int cost_3=costs[2]+solve(days,costs,j,dp); 


    //     int min=Math.min(cost_1,Math.min(cost_2,cost_3));

       
    //     return dp[idx]=min;
    // }
}