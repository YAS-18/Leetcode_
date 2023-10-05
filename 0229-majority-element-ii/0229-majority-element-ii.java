class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
            if(!ans.contains(x) && map.get(x) > nums.length/3)
                ans.add(x);
        }

        return ans;
    }
}