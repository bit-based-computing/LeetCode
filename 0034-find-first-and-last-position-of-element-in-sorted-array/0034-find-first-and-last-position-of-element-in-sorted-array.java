class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = findLowerBound(nums, target);
        int y = findUpperBound(nums, target);
        return new int[] {x,y};
    }

    int findLowerBound(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int found = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;  
            if(nums[mid] == target) {
                found = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return found;
    }

    int findUpperBound(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int found = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;  
            if(nums[mid] == target) {
                found = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return found;
    }
}