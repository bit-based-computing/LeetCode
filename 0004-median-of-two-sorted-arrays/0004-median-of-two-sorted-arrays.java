class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int half = total / 2;

        if (len1 > len2)
            return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = len1;

        while (true) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int nums1Left = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1Right = (i < len1) ? nums1[i] : Integer.MAX_VALUE;

            int nums2Left = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = (j < len2) ? nums2[j] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (total % 2 == 1) {
                    return Math.min(nums1Right, nums2Right);
                }
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
            } else if (nums1Left > nums2Right) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}