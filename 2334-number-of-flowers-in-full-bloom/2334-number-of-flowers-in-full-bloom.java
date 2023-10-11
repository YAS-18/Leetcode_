class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int ans[] = new int[people.length]; 
        int n = flowers.length;
        int []start = new int[n];
        int []end = new int[n];
        int i = 0;
        for(int x[] : flowers) {
            start[i] = x[0];
            end[i] = x[1];
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        i = 0;

        for(int x : people) {
            // the flowers that have bloomed before the present day
            int bloom = 0;
            int l = 0;
            int r = n-1;

            while(l <= r) {
                int mid = (l+r)/2;
                if(start[mid] <= x){
                    bloom = mid+1;
                    l = mid + 1;
                } else {
                    r = mid-1;
                }
            }

            // the flowers that have died before the present day
            int notBloom = 0;
            l = 0;
            r = n-1;

            while(l <= r) {
                int mid = (l+r) / 2;
                if(end[mid] >= x){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                    notBloom = mid + 1;
                }
            }

            ans[i++] = Math.abs(bloom - notBloom); 
        }
        
        return ans;
    }

}