class Solution {
    public int findKthLargest(int[] nums, int k) {
       int  cnt=0;
       int ans=0;
       PriorityQueue<Integer>pq=new PriorityQueue<>(
        (a,b)->b-a
       );
       for(int num:nums){
        pq.add(num);
       }
       while(!pq.isEmpty()){
        int temp=pq.poll();
        cnt++;
        if(cnt==k){
            ans=temp;
        }
       }
       return ans;
    }
}