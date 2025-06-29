class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind uf = new UnionFind(len);
        for(int[] edge: edges) {
            if(!uf.union(edge[0], edge[1])){
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {};
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
            
    }

    int find(int x) {
        // System.out.println(x + " " + parent[x]);
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return false;
        } else {
            if(rank[x] < rank[y]) {
                parent[x] = y;
                rank[y]++;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
                rank[x]++;
            } else {
                parent[x] = y;
                rank[y]++;
            }
        }
        return true;
    }
}