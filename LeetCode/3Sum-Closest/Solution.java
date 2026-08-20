1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        int n = nums.length;
4        Arrays.sort(nums);
5        int closest = nums[0]+nums[1]+nums[2];
6        for(int j = 0;j<n-2;j++){
7            int l = j+1 , r = n-1;
8            while(l<r){
9                int sum = nums[j]+nums[l]+nums[r];
10                if(Math.abs(sum-target)<Math.abs(closest-target)){
11                    closest = sum;
12                }
13                if(sum<target){
14                    l++;
15                }
16                else if(sum>target){
17                    r--;
18                }
19                else{
20                    return sum;
21                }
22            }
23        }
24        return closest;
25    }
26}