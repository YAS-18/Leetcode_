class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int i=0;
        for(; i<s.length() ; i++) {
            map1.put(s.charAt(i) , map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i) , map2.getOrDefault(t.charAt(i),0)+1);
        }

        map2.put(t.charAt(i) , map2.getOrDefault(t.charAt(i),0)+1);
        
        char ans = 'a';
        for(i=0 ; i<26 ; i++){
            ans = (char)(97 + i);
            if(map1.get(ans) != map2.get(ans))
                break;
        }
        return ans;
    }
}