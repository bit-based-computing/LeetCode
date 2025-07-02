class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        PriorityQueue<int[]> pqMin = new PriorityQueue<>((a, b)-> Integer.compare(b[1], a[1]));
        PriorityQueue<int[]> pqMax = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        for(int i = 0; i < len; i++) {
            if(capital[i] <= w) {
                pqMin.offer(new int[]{capital[i], profits[i]});
            } else {
                pqMax.offer(new int[]{capital[i], profits[i]});
            }
        }

        while( k > 0 && !pqMin.isEmpty()) {
              int[] project = pqMin.poll();
            //   System.out.println(project[0] + " " + project[1]);
              w = w + project[1];
              while(!pqMax.isEmpty() && pqMax.peek()[0] <= w) {
                pqMin.offer(pqMax.poll());
              }
              k--;
        }
        return w;
    }
}