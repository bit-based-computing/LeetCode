class Solution {
    public int longestOnes(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int fk = k;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                list.add(sum);
                if(sum != 0) list.add(0);
                sum = 0;
            }
        }
        if(sum != 0) list.add(sum);
        int l = 0;
        int r = 0;
        int maxSum = 0;
        sum = 0;
        while(l <= r && r < list.size()) {
            int num = list.get(r);
            if(num == 0) {
                if(k > 0) k--;
                else if(k <= 0) {
                    while(l <= r && list.get(l) != 0) {
                        sum -= list.get(l);
                        l++;
                    }
                    l++;
                    k = 0;
                }
                
            } else {
                sum += num;
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
            r++;
        }
        maxSum += fk;
        return Math.min(maxSum, len);
    }
}