class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = (int)1e9 + 7;
        arrLen = Math.min(arrLen , steps);
        int dp[][] = new int[steps+1][arrLen];
        dp[0][0] = 1;

        for(int step = 1 ; step <= steps ; step++) {
            for(int position = arrLen-1 ; position >= 0 ; position--) {
                // stay
                int ans = dp[step-1][position];

                // left
                if(position > 0)
                    ans = (ans + dp[step-1][position-1]) % mod;
                
                // right
                if(position < arrLen - 1)
                    ans = (ans + dp[step-1][position+1]) % mod;
                
                // final sum
                dp[step][position] = ans;
            }
        }

        return dp[steps][0];
    }
}