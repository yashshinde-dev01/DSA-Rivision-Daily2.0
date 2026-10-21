class Solution {
   
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
            
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[i]);
        findSubset(arr,n,i+1,temp);

        temp.remove(temp.size()-1);
        int idx=i+1;
        while(idx<arr.length && arr[idx]==arr[idx-1]){
            idx++;
        }

        findSubset(arr,n,idx,temp);
    }
}