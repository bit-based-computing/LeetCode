/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int getPeakIndex(int l, int r, MountainArray mountainArr) {
        l++;
        r--;
        while(l <= r ) {
            int mid = l + (r - l)/2;
            int midValue = mountainArr.get(mid);
            int x = mountainArr.get(mid - 1);
            int y = mountainArr.get(mid + 1);
            if(x < midValue && midValue > y) return mid;
            if(x < midValue) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }           
        }
        return -1;
    }
    public int findInAsending(int l, int r, int target, MountainArray mountainArr) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target)
                return mid;
            if (target < midValue)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int findInDecending(int l, int r, int target, MountainArray mountainArr) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target)
                return mid;
            if (target > midValue)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int l = 0;
        int r = mountainArr.length()-1;
        int peakIndex = getPeakIndex(l, r, mountainArr);
        if(mountainArr.get(peakIndex) == target) return peakIndex;
        int index = findInAsending(l, peakIndex-1, target, mountainArr);
        if(index != -1) return index;
        return findInDecending(peakIndex+1, r , target, mountainArr);
    }
}