class Solution {
    ArrayList<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer>temp=new ArrayList<>();
        combi(candidates,0,target,temp);
        return ans;
    }
    void combi(int[]arr,int i,int target,ArrayList<Integer>temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i>=arr.length || target<0){
            return;
        }
        temp.add(arr[i]);
        combi(arr,i+1,target-arr[i],temp);
        int index=i+1;
        while(index<arr.length && arr[index]==arr[index-1]){
            index++;
        }
        temp.remove(temp.size()-1);
        combi(arr,index,target,temp);
    }
}