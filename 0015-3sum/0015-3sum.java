class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int sum, x, left, right;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            x = nums[i];
            left = i + 1;
            right = len - 1;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum + x == 0) {
                    List<Integer> items = new ArrayList<>();
                    items.add(x);
                    items.add(nums[left]);
                    items.add(nums[right]);
                    ans.add(items);
                    left++;
                    right--;
                    while (left < right) {
                        if (nums[left] == nums[left - 1])
                            left++;
                        else
                            break;
                    }
                    while (left < right) {
                        if (nums[right] == nums[right + 1])
                            right--;
                        else
                            break;
                    }
                } else if (sum + x > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}