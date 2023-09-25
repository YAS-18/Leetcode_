class Solution {
    public char findTheDifference(String s, String t) {
        long sSum = 0;
        long tSum = 0;

        for(int i=0 ; i<s.length() ; i++){
            sSum += s.charAt(i);
            tSum += t.charAt(i);
        }

        tSum += t.charAt(t.length()-1);

        return (char)(tSum - sSum);
    }
}