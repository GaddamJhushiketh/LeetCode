1class Solution {
2    public static final long m = 1000000007L;
3    SegmentTree tree;
4    public int createSortedArray(int[] instructions) {
5        int n = instructions.length;
6        int max = instructions[0];
7        for(int i =0;i<n;i++){
8            max = Math.max(max,instructions[i]);
9        }
10        tree = new SegmentTree(max+1);
11        long ans = 0;
12        for(int i =0;i<n;i++){
13            int val = instructions[i];
14            long smaller = (tree.rangeQuery(0,val-1));
15            long gratter = (tree.rangeQuery(val+1,max));
16            ans=(ans+Math.min(smaller,gratter))%m;
17            tree.increment(val);
18        }
19        return (int)ans;
20    }
21}
22class SegmentTree{
23    long st[];
24    int n;
25    public SegmentTree(int n){
26        this.n = n;
27        st = new long[n*4];
28    }
29    long rangeQuery(int l, int r){
30        return query(0,0,n-1,l,r);
31    }
32    public long query(int idx,int ss,int se,int qs,int qe){
33        if(qs>qe ||qs>se ||qe<ss){
34            return 0;
35        }
36        if(ss>=qs && se<=qe){
37            return st[idx];
38        }
39        int mid = (ss+se)/2;
40        long left = query(2*idx+1,ss,mid,qs,qe);
41        long right = query(2*idx+2,mid+1,se,qs,qe);
42         return left+right;
43    }
44    public void increment(int x){
45        int idx = 0;
46        int ss = 0;
47        int se = n-1;
48        while(ss<se){
49            int mid = (ss+se)/2;
50            if(x<=mid){
51                idx = (2*idx+1);
52                se = mid;
53            }
54            else{
55                idx = (2*idx+2);
56                ss = mid+1;
57            }
58        }
59        while(true){
60            st[idx]++;
61            if(idx == 0){
62                break;
63            }
64            idx = (idx-1)/2;
65        }
66    }
67}