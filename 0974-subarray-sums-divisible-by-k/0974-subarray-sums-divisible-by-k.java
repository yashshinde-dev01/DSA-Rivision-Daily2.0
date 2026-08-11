class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
       int n=nums.length;
       int sum=0;
       map.put(0,1);
       int cnt=0;
       for(int num:nums){
        sum+=num;
        int rem=sum%k;
        if(rem<0)rem=sum%k+k;
        if(map.containsKey(rem)){
            cnt+=map.get(rem);
        }
        map.put(rem,map.getOrDefault(rem,0)+1);
       }
       return cnt;
       

    }
}