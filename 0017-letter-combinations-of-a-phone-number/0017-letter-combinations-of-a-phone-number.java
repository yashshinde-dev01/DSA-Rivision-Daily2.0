class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] arr = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
        };
        StringBuilder sb=new StringBuilder();

        if (digits.length() == 0) {
            return ans;
        }
        solve(arr,sb,0,digits);
        return ans;        
    }
    void solve(String[] arr,StringBuilder sb,int idx,String digits){
        // if(idx>=digits.length()){
        //     ans.add(sb.toString());
        //     return;
        // }
        if(sb.length()==digits.length() || idx>=digits.length()){
            ans.add(sb.toString());
            return;
        }

        String str=arr[digits.charAt(idx)-'0'];//"abc","def"

        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            solve(arr,sb,idx+1,digits);
            sb.deleteCharAt(sb.length()-1);
        } 
    }
}