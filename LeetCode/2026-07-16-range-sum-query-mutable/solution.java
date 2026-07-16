// Time complexity: O(n) for initialization, O(log n) for update and sumRange
// Space complexity: O(n)
class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - sumRange(index, index);
        while (index <= n) {
            tree[index] += diff;
            index += index & -index;
        }
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}