class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>ans = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            int lineWidth = 0;
            
            int j = i;
            while(j < words.length && 
                lineWidth + words[j].length() + (j-i) <= maxWidth){
                lineWidth += words[j].length(); 
                j++;
            }

            int numWords = (j-i);
            int totalSpace = maxWidth - lineWidth;
            String str = "";

            // System.out.print("\n" + numWords + " ");
                 
            if(numWords == 1 || j == words.length){
                str += words[i];
                
                for(int k=i+1 ; k<j ; k++){
                    str += ' ' + words[k];
                }
                
                int remSpace = maxWidth - str.length();

                char arr[] = new char[remSpace];
                Arrays.fill(arr,' ');
                String sp = new String(arr);

                str += sp;
            }
            else{ 
                int singleSpace = totalSpace / (numWords-1);
                int extraSpaces = (totalSpace % (numWords-1));               
                // System.out.print(singleSpace + " " + extraSpaces);
                
                char arr[] = new char[singleSpace];
                Arrays.fill(arr,' ');
                String sp = new String(arr);

                // System.out.print("[" + sp + "]");

                str += words[i];
                for(int k = i+1 ; k<j ; k++){
                    str += sp;
                    if(extraSpaces > 0){
                        str += ' ';
                        extraSpaces--;
                    }
                    str += words[k];   
                }
            }
            ans.add(str);
            i = j;
        }

        return ans;
    }
}