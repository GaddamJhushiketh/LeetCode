1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> ans = new ArrayList();
4        int n = nums.length;
5        if(n<3){
6            return ans;
7        }
8        Arrays.sort(nums);
9        for(int i=0;i<n-2;i++){
10            if(i>0 && nums[i] == nums[i-1]){
11                continue;
12            }
13            int l = i+1;
14            int r = n-1;
15            while(l<r){
16                int sum = nums[i]+nums[l]+nums[r];
17                if(sum == 0){
18                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
19                    while(l<r && nums[l] == nums[l+1]) l++;
20                    while(l<r && nums[r] == nums[r-1]) r--;
21                    l++;
22                    r--;
23                }
24                else if(sum<0){
25                    l++;
26                }
27                else{
28                    r--;
29                }
30            }
31        }
32        return ans;
33    }
34}