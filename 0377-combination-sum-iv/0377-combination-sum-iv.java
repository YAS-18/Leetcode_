class Solution {
    int dp[];
    int solve(int []nums , int target){
        if(dp[target] != -1)
            return dp[target];

        if(target == 0)
            return 1;

        int ans = 0;

        for(int k=0 ; k<nums.length ; k++){
            if(target >= nums[k])
                ans += solve(nums,target-nums[k]);
        }
        
        return dp[target] = ans;   
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);

        return solve(nums,target);
    }
}