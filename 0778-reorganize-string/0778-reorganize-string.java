class Solution {
    public String reorganizeString(String s) {
        if(s.length() == 1)
            return s;

        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<int []>que = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            int val = map.get(ch);
            map.put(ch,val+1);
        }

        if(map.size() == 1)
            return "";

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            que.add(new int[]{entry.getKey(),entry.getValue()});
        }

        String str = "";
        int i = 0;
        while(que.size() > 1){
            int []top = que.poll();
            if(str.length() == 0 || str.charAt(str.length()-1) != (char)(top[0])){
                str += (char)(top[0]);
                top[1] -= 1;
            }
            else{
                int secTop[] = que.poll();
                str += (char)(secTop[0]);
                secTop[1] -= 1;
                if(secTop[1] > 0)
                    que.add(secTop);    
            }
            
            if(top[1] > 0)
                que.add(top);
        }

        int last[] = que.poll();

        if(str.charAt(str.length()-1) != last[0] && last[1] == 1)
            str += (char)(last[0]);
        else{
            return "";
        }

        return str;
    }
}