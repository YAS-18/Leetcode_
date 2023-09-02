class Solution {
    Map<Character,List<String>> map = new HashMap<>();
    int dp[];
    int solve(int ind,String s){
        if(ind >= s.length())
            return 0;
        
        if(dp[ind] != -1)
            return dp[ind];

        char ch = s.charAt(ind);

        //skip curr char
        int notTake = solve(ind+1,s);

        //if map contains keys with curr char check their lengths
        int take = (int)-1e9;
        if(map.containsKey(ch)){
            for(String str : map.get(ch)){
                int len = str.length();
                if(ind+len <= s.length()){
                    String subStr = s.substring(ind,ind+len);
                    if(subStr.equals(str)){
                        take = Math.max(take , len + solve(ind+len,s));
                }
                }
            }
        }

        return dp[ind] = Math.max(notTake , take);
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        dp = new int [s.length()];
        Arrays.fill(dp,-1);

        for(String str:dictionary){
            char ch = str.charAt(0);
            if(!map.containsKey(ch)){
                map.put(ch,new ArrayList<>());
            }
            map.get(ch).add(str);
        }

        return (s.length() - solve(0,s));
    }
}