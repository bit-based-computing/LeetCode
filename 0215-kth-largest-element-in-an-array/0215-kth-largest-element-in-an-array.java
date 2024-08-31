class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
       }
       return pq.peek();       
    }

    // another better approce 

    /*

    public int findKthLargest(int[] nums, int k) {
        int[] counts = new int[20001];
        for(int num : nums) {
            counts[num + 10000]++;
        }
        int ithLargest = 0;
        int right = 20000;
        while(right >= 0) {
            if(counts[right] > 0) {
                ithLargest += counts[right];
                if(ithLargest >= k) {
                    break;
                }
            }
            right--;
        }
        return right - 10000;
    }

    */
   
}