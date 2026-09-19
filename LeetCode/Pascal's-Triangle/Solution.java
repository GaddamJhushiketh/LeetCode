1class Solution {
2    public List<List<Integer>> generate(int n) {
3        List<List<Integer>> ans = new ArrayList<>();
4        for(int i=0;i<n;i++){
5            List<Integer> inner = new ArrayList<>();
6            inner.add(1);
7            for(int j=1;j<i;j++){
8                int val = ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
9                inner.add(val);
10            }
11            if(i>0)
12            inner.add(1);
13            ans.add(inner);
14        }
15        return ans;
16    }
17}