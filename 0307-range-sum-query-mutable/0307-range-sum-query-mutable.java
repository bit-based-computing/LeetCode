class NumArray {
    Node head;
    public NumArray(int[] nums) {
        int sum = 0;
        int l = 0;
        int r = nums.length - 1;
        head = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        updateTree(head, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSum(head, left, right);
    }

    public Node buildTree(int[] nums, int l, int r) {
        if(l == r) return new Node(nums[l], l, r); 
        Node  node = new Node();
        int sum = 0;
        for(int i = l; i <= r; i++) {
            sum += nums[i];
        }
        node.sum = sum;
        node.l = l;
        node.r = r;
        int mid = l + (r - l)/2;
        node.left = buildTree(nums, l, mid);
        node.right = buildTree(nums, mid+1, r);
        return node;
    }

    public void updateTree(Node node, int index, int val) {
        if(node.l == index && node.r == index) {
            node.sum = val;
            return;
        }
        if(index <= node.left.r) {
            updateTree(node.left, index, val);
        } else {
            updateTree(node.right, index, val);
        } 
        node.sum = node.left.sum + node.right.sum;
    }

    public int getSum(Node node, int l, int r) {
        if(node.l == l && node.r == r) return node.sum;
        if(r <= node.left.r) {
            return getSum(node.left, l, r);
        } else if(l > node.left.r) {
            return getSum(node.right, l, r);
        }
        return getSum(node.left, l, node.left.r) + getSum(node.right, node.right.l, r);
    }
}

class Node {
    int sum = 0;
    int l = 0;
    int r = 0;
    Node left;
    Node right;
    
    Node(int sum, int l, int r) {
        this.sum = sum;
        this.l = l;
        this.r = r;
    }

    Node() {

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */