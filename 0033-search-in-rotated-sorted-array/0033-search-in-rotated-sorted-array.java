class Solution {
    public int search(int[] nums, int target) {
        int rotInd = 0;
        int n = nums.length;
        int l = 0;
        int h = n-1;

        while(l < h){
            int mid = (l+h)/2;

            if(nums[mid] > nums[h])
                l = mid+1;
            else 
                h = mid;
        }

        rotInd = l;
        l = 0;
        h = n-1;

        while(l <= h){
            int mid = (l + h)/2;

            int realMid = (mid + rotInd) % n;

            if(nums[realMid] == target) return realMid;
            if(nums[realMid] < target)  l = mid+1;
            else                        h = mid-1;
        }

        return -1;
    }
}