class Solution {
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            char ch1=s.charAt(l);
            char ch2=s.charAt(r);
            if(ch1!=ch2){
                return helper(s,l+1,r) || helper(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    static boolean helper(String s,int st,int e){
        int l=st;
        int r=e;
        while(l<r){
            char ch1=s.charAt(l);
            char ch2=s.charAt(r);
            if(ch1!=ch2){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}