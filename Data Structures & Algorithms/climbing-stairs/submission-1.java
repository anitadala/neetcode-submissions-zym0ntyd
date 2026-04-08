class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n==1 )
            return 1;
        if(n==2 )
            return 2;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] =  dp[i-1] + dp[i-2] ;
        }
        return dp[n];
    }
}
/*
n=1
1
n=2
2 options
n=3
1+dp[2] 
n=4 
2,2
2,1,1
1,1,2
1,1,1,1
1,2,1





*/