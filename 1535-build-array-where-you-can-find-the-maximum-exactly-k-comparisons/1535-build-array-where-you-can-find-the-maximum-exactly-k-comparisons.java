class Solution {
    int mod = (int)(1e9+7);
    long dp[][][];
    int N,M,K;
    long solve(int idx, int cost, int max) {
        if(N == idx) {
            return K == cost?1:0;
        }

        if(dp[idx][max][cost] != -1)
            return dp[idx][max][cost];

        long ans = 0;
        for(int i=1 ; i<=M ; i++){
            if(i > max) {
                ans += solve(idx + 1, cost + 1, i) % mod;
            } else {
                ans += solve(idx + 1, cost, max) % mod;
            }     
        }

        return dp[idx][max][cost] = ans % mod;
    }

    public int numOfArrays(int n, int m, int k) {
        dp = new long[51][101][51];
        for(long x[][] : dp)
            for(long y[] : x)
                Arrays.fill(y,-1);
        M = m;
        N = n;
        K = k;

        return (int)solve(0,0,0) % mod;
    }
}