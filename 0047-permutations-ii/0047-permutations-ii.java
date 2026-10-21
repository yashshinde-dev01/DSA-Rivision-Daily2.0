class Solution {
    ArrayList<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
         ArrayList<Integer>temp=new ArrayList<>();
        int n=nums.length;
        boolean[]visi=new boolean[n];
        permu(nums,visi,temp);
        return ans;
    }
     void permu(int[]arr,boolean[]visi,ArrayList<Integer>temp){
        int n=arr.length;

        if(temp.size()==arr.length){
            ans.add(new ArrayList<>(temp));
        }
        for(int i=0;i<n;i++){
            if (visi[i]) continue;

          if (i > 0 && arr[i] == arr[i - 1] && !visi[i - 1]) {
            continue;
         }
                visi[i]=true;
                temp.add(arr[i]);
                permu(arr,visi,temp);
                temp.remove(temp.size()-1);
                visi[i]=false;
            
        }
    }
}