1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        int  n = nums.length;
4        for(int i =0;i<n;i++){
5            nums[i] *=nums[i];
6        }
7        Arrays.sort(nums);
8        long ans =0;
9        for(int i =0;i<n/2;i++){
10            ans -= nums[i];
11        }
12        for(int i=n/2;i<n;i++){
13            ans+=nums[i];
14        }
15        return ans;
16    }
17}