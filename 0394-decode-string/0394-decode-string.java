class Solution {
    public String decodeString(String s) {
        Stack<Integer>st1=new Stack<>();
        Stack<String>st2=new Stack<>();
        int cnt=0;
        String curr="";
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                cnt=cnt*10+(ch-'0');
            }else if(ch=='['){
                st1.push(cnt);
                st2.push(curr);
                cnt=0;
                curr="";
            }else if( ch==']'){
                int repeat=st1.pop();
                String prev=st2.pop();

                StringBuilder temp=new StringBuilder(prev);

                for(int i=0;i<repeat;i++){
                    temp.append(curr);
                }
                curr=temp.toString();
            }else{
                curr+=ch;
            }
            
        }
        return curr;
    }
}