class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack();
        st.push(0);
        for(int i=0;i<s.length(); i++){
           char ch=s.charAt(i);
           if(ch=='('){
            st.push(0);
           }else{
            int val=st.pop();
            int score=Math.max(2*val,1);
            st.push(st.pop()+score);
           }
        }
        return st.pop();
    }
}