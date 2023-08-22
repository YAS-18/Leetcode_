class Solution {
    
    public String convertToTitle(int columnNumber) {
        String ans = "";
        

        while(columnNumber > 0){
            if(columnNumber > 26){
                columnNumber--;
                int x = (columnNumber % 26);
                System.out.println(x);
                char ch = (char)(65 + x);
                ans = ch + ans;
            }
            else {
                char ch = (char)(64 + columnNumber);
                ans = ch + ans;
                break;
            }
            columnNumber /= 26;   
        }

        return ans;
    }
}