/* f(1) = 1
    f(2) = 2
    f(3) = f(1) + f(2)= 3
    f(4) = f(2) + f(3) = 2+3= 5 
*/

class Solution{
    
    public  int climbStairs(int n){
        if(n==1 || n==2) return n;

        int a =1; // init with f1 
        int b =2; // init with f2
        int tmp =0;
        //int[] dp = new int[n];
        //dp[0]=1;
        //dp[1]=2;

        for(int i =3; i <=n; ++i){
            tmp = a+b;
            a = b;
            b = tmp; 
        }

        return tmp;

    }

}
