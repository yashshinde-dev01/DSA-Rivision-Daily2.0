class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length)return -1;

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        for(int num:nums){
            pq.offer(num);
        }
        int kthele=0;
        while(k!=0){
           kthele= pq.poll();
           k--;
        }
        return kthele;
    }
}