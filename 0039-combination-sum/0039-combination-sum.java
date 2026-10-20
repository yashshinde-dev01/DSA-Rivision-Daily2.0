class Solution {
    ArrayList<List<Integer>>ans=new ArrayList<>();
    HashSet<ArrayList<Integer>>set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer>temp=new ArrayList<>();
        combiSum(candidates,target,0,temp);
        return ans;
    }
    void  combiSum(int[]arr,int target,int i,ArrayList<Integer>temp){
        if(target==0){
            if(!set.contains(temp)){
                ans.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
                return;
            }
        }
        if(i>=arr.length || target<0){
            return;
        }
        
        temp.add(arr[i]);
         combiSum(arr,target-arr[i],i,temp);
         temp.remove(temp.size()-1);
         combiSum(arr,target,i+1,temp);
    }
}