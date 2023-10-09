class Solution {
    int lowerBound(int nums[],int l,int h,int k){
        int ans = nums.length;
        while(l <= h){
            int mid = (h + l)/2;

            if(nums[mid] >= k){
                ans = mid;
                h = mid - 1;
            }
            else
                l = mid+1;
        }

        return ans;
    }
    int upperBound(int nums[],int l,int h,int k){
         int ans = nums.length;
         while(l <= h){
            int mid = (h + l)/2;

            if(nums[mid] > k){
                ans = mid;
                h = mid - 1;
            }
            else
                l = mid + 1;
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int lb = lowerBound(nums,0,n-1,target);

        if(lb == n || nums[lb] != target)
            return new int[]{-1,-1};

        int ub = upperBound(nums,0,n-1,target);

        return new int[]{lb,ub-1};
    }
}