/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node buildTree(int[][] grid, int rs, int re, int cs, int ce) {
        boolean hasOne = false;
        boolean hasZero = false;
        boolean val = false;
        boolean isLeaf = false;
        Node root = null;
        for(int i = rs; i <= re; i++) {
            for(int j = cs; j <= ce; j++) {
                if(grid[i][j] == 1) {
                    hasOne = true;
                } else {
                    hasZero = true;
                }
                if (hasOne && hasZero) break;
            }
            if (hasOne && hasZero) break;
        }
        isLeaf = !(hasOne && hasZero);
        val = hasOne;
        root = new Node(val, isLeaf);
        if(!isLeaf) {
            int midRow = rs + (re - rs) / 2;
            int midCol = cs + (ce - cs) / 2;
            root.topLeft = buildTree(grid, rs, midRow, cs, midCol);
            root.topRight = buildTree(grid, rs, midRow, midCol + 1, ce);
            root.bottomLeft = buildTree(grid, midRow+1, re, cs, midCol);
            root.bottomRight = buildTree(grid, midRow+1, re, midCol+1, ce);
        }

        return root;
    }
    public Node construct(int[][] grid) {
        int row = grid.length;
        return buildTree(grid, 0, row - 1, 0, row - 1);
    }
}