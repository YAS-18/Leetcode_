class Solution {
    int mod = (int)(1e9+7);
    long dp[][];
    long solve(int p_cnt, int d_cnt, int n, boolean p_vis[], boolean d_vis[]){
        if(p_cnt == n && d_cnt == n){
            return 1;
        }

        if(dp[p_cnt][d_cnt] != -1)
            return dp[p_cnt][d_cnt];

        long ans = 0;
        for(int i=0 ; i<n ; i++){
            if(!p_vis[i]){
                p_vis[i] = true;
                ans += solve(p_cnt+1 , d_cnt, n, p_vis, d_vis) % mod;
                p_vis[i] = false;
            }

            if(p_vis[i] && !d_vis[i]){
                d_vis[i] = true;
                ans += solve(p_cnt, d_cnt+1 , n, p_vis, d_vis) % mod;
                d_vis[i] = false;
            }
        }

        return dp[p_cnt][d_cnt] = ans % mod;
    }
    public int countOrders(int n) {
        boolean p_vis[] = new boolean[n];
        boolean d_vis[] = new boolean[n];
        dp = new long[n+1][n+1];
        for(long x[] : dp)
            Arrays.fill(x,-1);

        int ans = (int)(solve(0,0,n,p_vis,d_vis) % mod);

        return ans;
    }
}