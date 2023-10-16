class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans = new ArrayList<>();
        int row = 0;
        while(row <= rowIndex+1) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0 ; i<row ; i++) {
                if(i == 0 || i == row-1) {
                    temp.add(1);
                } else {
                    temp.add(ans.get(i-1) + ans.get(i));
                }
            }
            ans = temp;
            row++;
        }

        return ans;
        
    }
}