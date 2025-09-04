class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            tree = new int[4 * n];
            build(nums, 0, 0, n - 1);
        }
    }

    private void build(int[] nums, int idx, int l, int r) {
        if (l == r) {
            tree[idx] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(nums, 2 * idx + 1, l, mid);
        build(nums, 2 * idx + 2, mid + 1, r);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    private void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            tree[idx] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (pos <= mid) {
            update(2 * idx + 1, l, mid, pos, val);
        } else {
            update(2 * idx + 2, mid + 1, r, pos, val);
        }
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0; // no overlap
        if (ql <= l && r <= qr) return tree[idx]; // total overlap
        int mid = l + (r - l) / 2;
        return query(2 * idx + 1, l, mid, ql, qr) +
               query(2 * idx + 2, mid + 1, r, ql, qr);
    }
}
