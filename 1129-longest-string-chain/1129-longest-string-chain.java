class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    int solve(String str , ArrayList<String>set){
        if(set.size() == 0 || str.length() == 0)
            return 1;
        
        if(dp.containsKey(str))
            return dp.get(str);

        int ans = 1;
        for(int i=0 ; i<str.length() ; i++){
            String substr = "";
            if(i == 0)
                 substr += str.substring(i+1);
            else
                substr += str.substring(0,i) + str.substring(i+1);
            if(set.contains(substr)){
                int j = set.indexOf(substr);
                set.remove(j);
                ans = Math.max(ans , 1 + solve(substr,set));
                set.add(j,substr);
            }
        }

        dp.put(str,ans);
        return ans;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->(b.length() - a.length()));
        // for(String str : words)
        //     System.out.print(str + " ");

        ArrayList<String> set = new ArrayList<>(Arrays.asList(words));
        int ans = Integer.MIN_VALUE;
        for(int i=0 ; i<set.size() ; i++){
            String str = set.get(i);
            set.remove(i);
            ans = Math.max(ans,solve(str,set));
            set.add(i,str);
        }

        return ans;
    }
}