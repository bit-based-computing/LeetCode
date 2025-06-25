class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        int size = 0;
        int l = 0;
        int r = size;
        for(int num: nums) {
            l = 0;
            r = size;
            while(l < r) {
                int mid = l + (r-l)/2;
                if(tail[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(l == size){
                size++;
            } 
            tail[l] = num;
        }
        return size;
    }
}