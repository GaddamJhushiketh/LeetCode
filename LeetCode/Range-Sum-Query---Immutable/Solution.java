1class NumArray {
2    int[] prefix;
3    public NumArray(int[] nums) {
4        prefix = new int[nums.length + 1];
5        for (int i = 0; i < nums.length; i++) {
6            prefix[i + 1] = prefix[i] + nums[i];
7        }
8    }
9    public int sumRange(int left, int right) {
10        return prefix[right + 1] - prefix[left];
11    }
12}
13
14/**
15 * Your NumArray object will be instantiated and called as such:
16 * NumArray obj = new NumArray(nums);
17 * int param_1 = obj.sumRange(left,right);
18 */