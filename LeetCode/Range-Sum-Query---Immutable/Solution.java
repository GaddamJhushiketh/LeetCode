1class NumArray {
2    SegmentTree tree;
3    public NumArray(int[] nums) {
4        tree = new SegmentTree(nums);
5    }
6    public int sumRange(int left, int right) {
7        return tree.sum(left,right);
8    }
9}
10class SegmentTree{
11    int[] a;
12    int[] st;
13    int n;
14    public SegmentTree(int[] arr){
15        this.n = arr.length;
16        this.a = new int[n];
17        for(int i =0;i<arr.length;i++){
18            a[i] = arr[i];
19        }
20        st = new int[4*n];
21        build_st(0,0,n-1);
22    }
23    void build_st(int idx,int ss,int se){
24        if(ss>se) return;
25        if(ss == se){
26            st[idx] = a[ss];
27            return;
28        }
29        int m =(ss+se)/2;
30        build_st(2*idx+1,ss,m);
31        build_st(2*idx+2,m+1,se);
32        st[idx] = st[2*idx+1] + st[2*idx+2];
33    }
34    public int sum(int l,int r){
35        return rangeSum(0,0,n-1,l,r);
36    }
37    private int rangeSum(int idx, int ss, int se, int qs, int qe){
38        if(qe<ss ||qs>se){
39            return 0;
40        }
41        if(ss>=qs && se <=qe){
42            return st[idx];
43        }
44        int m = (ss+se)/2;
45        int leftsum = rangeSum(2*idx+1,ss,m,qs,qe);
46        int rightsum = rangeSum(2*idx+2,m+1,se,qs,qe);
47        return leftsum+rightsum;
48    }
49}
50/**
51 * Your NumArray object will be instantiated and called as such:
52 * NumArray obj = new NumArray(nums);
53 * int param_1 = obj.sumRange(left,right);
54 */