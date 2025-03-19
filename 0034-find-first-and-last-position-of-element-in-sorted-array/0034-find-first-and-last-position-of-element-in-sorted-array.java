class Solution {
    public int upperBound(int nums[], int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                l = mid + 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int lowerBound(int nums[], int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                r = mid - 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = lowerBound(nums, target);
        int upperBound = upperBound(nums, target);
        return new int[] {lowerBound, upperBound};
    }
}