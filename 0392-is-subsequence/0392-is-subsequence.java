class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
            
        int ptr = 0;

        for(int i=0 ; i<t.length() ; i++) {
            if(s.charAt(ptr) == t.charAt(i)) {
                ptr++;
            }

            if(ptr == s.length())
                return true;
        }

        return false;
    }
}