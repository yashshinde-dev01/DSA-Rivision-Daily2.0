class Solution {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        // HashSet<Character>set=new HashSet<>();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-ch)==32){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}