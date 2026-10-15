1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int ans =0;
4        int n = nums.size();
5        for(int i =0;i<n;i++){
6            HashSet<Integer> dic = new HashSet<>();
7            for(int j = i;j<n;j++){
8                dic.add(nums.get(j));
9                ans+=dic.size()*dic.size();
10            }
11        }
12        return ans;
13    }
14}