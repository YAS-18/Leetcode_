class Solution {
    long dp[][];
    long solve(int idx1, int idx2, int nums1[], int nums2[], int length) {
        if(idx1 == nums1.length || idx2 == nums2.length) {
            return length == 0 ? (long)(-1e9) : 0;
        }

        if(dp[idx1][idx2] != 0)
            return dp[idx1][idx2];

        long c1 = nums1[idx1]*nums2[idx2] + 
                  solve(idx1+1, idx2+1, nums1, nums2, length+1);
        long c2 = solve(idx1+1 , idx2, nums1, nums2 , length);
        long c3 = solve(idx1, idx2+1, nums1, nums2, length);
        long c4 = solve(idx1+1 , idx2+1, nums1, nums2, length);

        long max = Math.max(c1, Math.max(c2, Math.max(c3, c4)));

        return dp[idx1][idx2] = max;

    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new long[nums1.length][nums2.length];

        return (int)solve(0,0,nums1,nums2, 0);
    }
}