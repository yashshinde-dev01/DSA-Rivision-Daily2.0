class Solution {
    public double myPow(double x, int n) {
    double ans=1;
    long exp=n;
     if(exp<0){
        exp=-(exp);
        x=1/x;
     }  
     return power(x,exp,ans);

    }
    double power(double x,long n,double ans){
        if(n==0){
            return ans;
        }
        if(n%2!=0){
            ans*=x;
        }
        return power(x*x,n/2,ans);
    }
}