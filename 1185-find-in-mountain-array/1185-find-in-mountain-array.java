/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution { 
        public int findInMountainArray(int target, MountainArray arr) {
        int l = 0;
        int h = arr.length() - 1;
        int peak = -1;

        while(l < h){
            int mid = (l+h)/2;

            if(arr.get(mid) < arr.get(mid+1)){
                peak = mid  + 1;
                l = mid+1;
            }
            else
                h = mid;
        }


        l = 0;
        h = peak;

        while(l <= h) {
            int mid = (l + h)/2;

            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) > target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = peak;
        h = arr.length() - 1; 
        while(l <= h) {
            int mid = (l + h)/2;

            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) < target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1; 

    }

}