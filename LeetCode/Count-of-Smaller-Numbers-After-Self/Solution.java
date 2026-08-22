1class Solution {
2    SegmentTree tree;
3    public List<Integer> countSmaller(int[] nums) {
4        int n = nums.length;
5        int offset = 100000;
6        tree = new SegmentTree(200001);
7        List<Integer> ans = new ArrayList<>();
8        for(int i = n-1;i>=0;i--){
9            int val = nums[i]+offset;
10            ans.add(0,tree.query(0,0,200000,0,val-1));
11            tree.UpdateArray(0,0,200000,val);
12        }
13        return ans;
14    }
15}
16class SegmentTree{
17    int[] st;
18    int n;
19    public SegmentTree(int n){
20        this.n = n; 
21        st = new int[4*n];
22    }
23    public int query(int idx, int ss, int se, int qs, int qe){
24        if(qe<ss ||qs>se || qs>qe){
25            return 0;
26        }
27        if(ss>=qs && se <=qe){
28            return st[idx];
29        }
30        int m = (ss+se)/2;
31        int l = query(2*idx+1,ss,m,qs,qe);
32        int r = query(2*idx+2,m+1,se,qs,qe);
33        return l+r;
34    }
35    public void UpdateArray(int idx,int ss,int se, int pos){
36        if(ss == se){
37            st[idx] = st[idx]+1;
38            return;
39        }
40        int m = (ss+se)/2;
41        if(pos<=m)
42        UpdateArray(2*idx+1,ss,m,pos);
43        else
44        UpdateArray(2*idx+2,m+1,se,pos);
45        st[idx] = st[2*idx+1] + st[2*idx+2];
46    }
47}