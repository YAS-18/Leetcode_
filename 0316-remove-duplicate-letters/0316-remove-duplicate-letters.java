class Solution {
    public String removeDuplicateLetters(String s) {
      int lastIndex[] = new int[26];
        
      for(int i=0 ; i<s.length() ; i++){
          lastIndex[s.charAt(i) - 'a'] = i;
      }
        
      Boolean visited[] = new Boolean[26];
      Arrays.fill(visited,false);  
      Stack<Integer> stack = new Stack<Integer>(); 
        
      for(int i=0 ; i<s.length() ; i++){
          int curr = s.charAt(i) - 'a';
          if(visited[curr] == true) continue;
          
          while(!stack.isEmpty() && curr<stack.peek() && i<lastIndex[stack.peek()]){
              visited[stack.peek()] = false;
              stack.pop();
          }
          
          stack.push(curr);
          visited[curr] = true;
      }
     
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.append((char) (stack.pop() + 'a'));
       
        return ans.reverse().toString();  
    }
}