class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = 
                           new PriorityQueue<Integer>(Collections.reverseOrder());

       for(int i:nums){
           pQueue.add(i);
       } 
       
       int ans = 0;
       
       while(k!=0){
           ans = pQueue.poll();
           k--;
       }
      return ans;
    }
}
