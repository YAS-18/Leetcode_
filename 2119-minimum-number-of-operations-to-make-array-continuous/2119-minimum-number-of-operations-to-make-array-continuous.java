class Solution { 
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums)   
            set.add(x);

        int newNums[] = new int[set.size()];
        int indx = 0;
        for(int x : set)
            newNums[indx++] = x;
            
        Arrays.sort(newNums);

        int ans = n;

        for(int i=0 ; i<newNums.length ; i++){
            int start = newNums[i];
            int end = start + n - 1;
            // gives the index of the highest continuous value in array
            int j = binarySearch(newNums, end); 
            // get the count of missing values for current countinuos 
            // range and substract from total length
            int miss = n - (j - i);
            ans = Math.min(ans, miss);
        }

        return ans;
    }

    int binarySearch(int nums[], int target) {
        int low = 0;
        int high = nums.length;

        while(low < high) {
            int mid = (low + high)/2;
            if(nums[mid] > target) 
                high = mid;
            else
                low = mid+1;
        }

        return low;
    }
}