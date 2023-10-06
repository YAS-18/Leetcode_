class Solution {
    int dp[];
    int solve(int n , int x) {
        if(dp[n] != -1)
            return dp[n]*x;

        if(n <= 2)
            return dp[n] = 1;
        
        int max = n * x;

        for(int i=1 ; i<=n/2 ; i++) {
            max = Math.max(max , x * solve(n-i , i));
        }

        return dp[n] = max;
    }
    public int integerBreak(int n) {
        if(n == 3)
            return 2;
        
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n,1);
    }
}