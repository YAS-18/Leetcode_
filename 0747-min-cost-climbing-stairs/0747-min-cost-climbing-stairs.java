class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans[] = new int[n];

        ans[n-1] = cost[n-1];
        ans[n-2] = cost[n-2];

        for(int i = n-3 ; i>=0 ; i--) {
            ans[i] = cost[i] + Math.min(ans[i+1] , ans[i+2]);
        }

        return Math.min(ans[0],ans[1]);
    }
}