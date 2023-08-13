class Solution {
    int dp[];
    boolean solve(int ind,int []nums){
        if(ind >= nums.length){
            return true;
        }

        if(dp[ind] != -1)
            return dp[ind] == 0?false:true;

        boolean ans = false;

        if(ind+1 < nums.length && nums[ind] == nums[ind+1]){
            System.out.println("condition->1");
            ans |= solve(ind+2 , nums);
        }

        if(ind+2 < nums.length && nums[ind] == nums[ind+1] && 
            nums[ind] == nums[ind+2]){
            System.out.println("condition->2");
            ans |= solve(ind+3 , nums);
        }
        
        if(ind+2 < nums.length && nums[ind+1] - nums[ind] == 1 && 
            nums[ind+2]- nums[ind+1] == 1){
            System.out.println("condition->3");
            ans |= solve(ind+3 , nums);
        }
        
        dp[ind] = ans == true?1:0;
        
        return dp[ind] == 0?false:true;
    }
    public boolean validPartition(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }
}