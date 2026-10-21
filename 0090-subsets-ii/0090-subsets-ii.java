class Solution {
    HashSet<List<Integer>>set=new HashSet<>();
    ArrayList<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>temp=new ArrayList<>();
        int n=nums.length;
        findSubset(nums,n,0,temp);
        return ans;
    }
    void findSubset(int[]arr,int n,int i,ArrayList<Integer>temp){
        if(i==n){
            if(!set.contains(temp)){
                ans.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
                
            }
            return;
        }
        temp.add(arr[i]);
        findSubset(arr,n,i+1,temp);

        temp.remove(temp.size()-1);

        findSubset(arr,n,i+1,temp);
    }
}