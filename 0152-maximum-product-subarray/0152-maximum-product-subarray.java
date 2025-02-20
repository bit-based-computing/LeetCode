class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int positiveProd = 1;
        int negativeProd = 1;
        for(int num: nums) {
            positiveProd *= num;
            negativeProd *= num;
            if(negativeProd > positiveProd){
                int temp = positiveProd;
                positiveProd = negativeProd;
                negativeProd = temp;
            } 
            if(positiveProd > max) max = positiveProd;
            if(positiveProd <= 0) positiveProd = 1;
            if(negativeProd == 0) negativeProd = 1;
        }
        return max;
    }
}