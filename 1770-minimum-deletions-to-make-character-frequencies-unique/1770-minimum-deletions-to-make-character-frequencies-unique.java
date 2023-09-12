class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer>map =  new HashMap<>();

        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        Set<Integer>set = new HashSet<>();
        int ans = 0;
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            int cnt = entry.getValue();
            while(cnt > 0 && set.contains(cnt)){
                ans++;
                cnt--;
            }

            set.add(cnt);
        }

        return ans;
    }
}