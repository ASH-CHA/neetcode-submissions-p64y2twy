class SegmentTree {

    private int[] tree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int node, int start, int end){
        if(start == end){
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        build(nums, leftChild, start, mid);
        build(nums, rightChild, mid + 1, end);
        tree[node] = tree[leftChild] + tree[rightChild];
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    private void update(int node, int start, int end, int index, int val){
        if(start == end){
            tree[node] = val;
            return;
        }
        
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        if(index <= mid){
            update(leftChild, start, mid, index, val);
        }
        else{
            update(rightChild, mid + 1, end, index, val);
        }
        tree[node] = tree[leftChild] + tree[rightChild];
    }

    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R){
        if(R < start || end < L) return 0;
        if(L <= start && end <= R) return tree[node];

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        int leftSum = query(leftChild, start, mid, L, R);
        int rightSum = query(rightChild, mid + 1, end, L, R);
        return leftSum + rightSum;
    }
}