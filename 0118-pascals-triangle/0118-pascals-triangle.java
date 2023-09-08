class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans  = new ArrayList<>();

        for(int i=0 ; i<=numRows ; i++){
            ArrayList<Integer>temp = new ArrayList<>();
            for(int j=0 ; j<i ; j++){
                if(j == 0 || j == i-1){
                   temp.add(1);
                }else{
                   temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        ans.remove(0);
        return ans;
    }
}