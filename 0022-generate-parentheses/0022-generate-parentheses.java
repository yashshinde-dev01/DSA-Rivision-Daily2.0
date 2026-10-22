class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();

        Para(sb,n);
        return ans;
    }
    void Para(StringBuilder sb,int n){
        if(sb.length()==2*n){
            if(isvalid(sb)){
                ans.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        Para(sb,n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        Para(sb,n);
        sb.deleteCharAt(sb.length()-1);
    }
    boolean isvalid(StringBuilder sb){
        int cnt=0;
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
            return false;
        }
        }
        
        return cnt==0;
    }
}