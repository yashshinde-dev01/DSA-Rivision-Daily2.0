class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(
        (a,b)->Integer.compare(a[0],b[0])
        );
        ArrayList<List<Integer>>ans=new ArrayList<>();

        if(nums1.length==0|| nums2.length==0 || k==0){
            return ans;
        }

        for(int i=0;i<nums1.length;i++){
            pq.offer(new int[]{nums1[i]+nums2[0],i,0});
        }

        int cnt=0;
        while(cnt<k && !pq.isEmpty()){
            int[]current=pq.poll();

            int i=current[1];
            int j=current[2];

            ans.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));

            if(j+1<nums2.length){
                pq.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
            cnt++;
        }
        return ans;




    }
}