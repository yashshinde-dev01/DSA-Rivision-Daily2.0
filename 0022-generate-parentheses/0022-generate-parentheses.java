class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        int open=0;
        int close=0;
        Para(sb,n,open,close);
        return ans;
    }
    void Para(StringBuilder sb,int n,int open,int close){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
        sb.append('(');
        Para(sb,n,open+1,close);
        sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
        sb.append(')');
        Para(sb,n,open,close+1);
        sb.deleteCharAt(sb.length()-1);
        }
    }
    
}