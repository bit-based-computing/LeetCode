import java.util.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dists = new int[6];
        dists[0] = distSq(p1, p2);
        dists[1] = distSq(p1, p3);
        dists[2] = distSq(p1, p4);
        dists[3] = distSq(p2, p3);
        dists[4] = distSq(p2, p4);
        dists[5] = distSq(p3, p4);

        Arrays.sort(dists);

        // Smallest 4 must be equal (sides), last 2 must be equal (diagonals)
        return dists[0] > 0 && 
               dists[0] == dists[1] && 
               dists[1] == dists[2] && 
               dists[2] == dists[3] && 
               dists[4] == dists[5] && 
               dists[4] > dists[0];
    }

    private int distSq(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + 
               (a[1] - b[1]) * (a[1] - b[1]);
    }
}
