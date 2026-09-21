class Solution {
    public double myPow(double x, int n) {
    double ans=1;
    long exp=n;
     if(exp<0){
        exp=-(exp);
        x=1/x;
     }  
     while(exp>0){
        if(exp%2!=0){
            ans*=x;
        }
        x=x*x;
        exp=exp/2;
     }
     return ans;

    }
}