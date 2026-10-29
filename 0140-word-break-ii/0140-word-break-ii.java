class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }

        StringBuilder sb=new StringBuilder();

        solve(0,sb,s,set);
        return ans;
    }
    void solve(int idx,StringBuilder sb, String s, HashSet<String>set){
        if(idx>=s.length()){
            ans.add(sb.toString());
            return;
        }
        for(int i=idx;i<s.length();i++){
            String tempword=s.substring(idx,i+1);
            if(set.contains(tempword)){
                int prevLength=sb.length();
                if(!sb.isEmpty()){
                    sb.append(" ");
                }
                sb.append(tempword);
                solve(i+1,sb,s,set);
                sb.setLength(prevLength);
            }
        }
    }
}