1class NumArray {
2    SegmentTree tree;
3    public NumArray(int[] nums) {
4        tree = new SegmentTree(nums);
5    }
6    public void update(int index, int val) {
7        tree.Update(index,val);
8    }
9    
10    public int sumRange(int left, int right) {
11        return tree.sum(left,right);
12    }
13}
14class SegmentTree{
15    int[] a;
16    int[] st;
17    int n;
18    public SegmentTree(int[] arr){
19        this.n = arr.length;
20        this.a = new int[n];
21        for(int i =0;i<arr.length;i++){
22            a[i] = arr[i];
23        }
24        st = new int[4*n];
25        build_st(0,0,n-1);
26    }
27    void build_st(int idx,int ss,int se){
28        if(ss>se) return;
29        if(ss == se){
30            st[idx] = a[ss];
31            return;
32        }
33        int m =(ss+se)/2;
34        build_st(2*idx+1,ss,m);
35        build_st(2*idx+2,m+1,se);
36        st[idx] = st[2*idx+1] + st[2*idx+2];
37    }
38    public int sum(int l,int r){
39        return rangeSum(0,0,n-1,l,r);
40    }
41    private int rangeSum(int idx, int ss, int se, int qs, int qe){
42        if(qe<ss ||qs>se){
43            return 0;
44        }
45        if(ss>=qs && se <=qe){
46            return st[idx];
47        }
48        int m = (ss+se)/2;
49        int leftsum = rangeSum(2*idx+1,ss,m,qs,qe);
50        int rightsum = rangeSum(2*idx+2,m+1,se,qs,qe);
51        return leftsum+rightsum;
52    }
53    public void Update(int pos, int value){
54        UpdateArray(0,0,n-1,pos,value);
55    }
56    public void UpdateArray(int idx,int ss,int se, int pos,int val){
57        if(ss>se) return;
58        if(ss == se){
59            a[ss] = val;
60            st[idx] = val;
61            return;
62        }
63        int m = (ss+se)/2;
64        if(pos<=m)
65        UpdateArray(2*idx+1,ss,m,pos,val);
66        else
67        UpdateArray(2*idx+2,m+1,se,pos,val);
68        st[idx] = st[2*idx+1] + st[2*idx+2];
69    }
70}
71/**
72 * Your NumArray object will be instantiated and called as such:
73 * NumArray obj = new NumArray(nums);
74 * obj.update(index,val);
75 * int param_2 = obj.sumRange(left,right);
76 */