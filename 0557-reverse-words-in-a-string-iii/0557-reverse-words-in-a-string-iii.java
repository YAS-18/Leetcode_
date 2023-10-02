class Solution {
    public String reverseWords(String s) {  
        String ans = "";
        for(int i=0 ; i<s.length() ; i++) {
            String str = "";
            while(i<s.length() && s.charAt(i) != ' ') {
                str = s.charAt(i) + str;
                i++;
            }
            
            if(i == s.length())
                ans += str;
            else
                ans += str + " ";
        }

        return ans;
    }
}