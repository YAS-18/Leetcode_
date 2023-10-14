class Solution {
    int dp[][];
    int solve(int i, int totalWalls, int cost[], int time[]){
        if(totalWalls <= 0)
            return 0;

        if(i >= time.length)
            return (int)1e9;

        if(dp[i][totalWalls] != -1)
            return dp[i][totalWalls];
        
        //paid
        int paid = cost[i] 
                   + solve(i+1, totalWalls-time[i]-1, cost, time);

        // unpaid
        int unpaid = solve(i+1,totalWalls, cost, time);
        
        return dp[i][totalWalls] = Math.min(paid, unpaid);
    }
    public int paintWalls(int[] cost, int[] time) {
        dp = new int[time.length][time.length+1];
        for(int x[] : dp)
            Arrays.fill(x,-1);

        return solve(0, time.length, cost, time);
    }
}