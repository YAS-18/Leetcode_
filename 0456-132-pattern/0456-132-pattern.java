class Solution {
    public boolean find132pattern(int[] nums) {
        //monotonic decreasing stack...
        Stack<Integer> stk = new Stack<>();

        int middle = Integer.MIN_VALUE;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(nums[i] < middle)
                return true;

            while(!stk.isEmpty() && nums[i] > stk.peek())
                middle = stk.pop();
            

            stk.push(nums[i]);
        }

        return false;
    }
}