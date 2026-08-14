1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5        int nums[] = new int[n+m];
6        int i =0;
7        for(i =0;i<n;i++){
8            nums[i] = nums1[i];
9        }
10        for(int j=0;j<m;j++){
11            nums[i++] = nums2[j];
12        }
13        Arrays.sort(nums);
14        int x = nums.length;
15        double ans = 0;
16        if(x%2 == 0){
17            ans = (nums[(x/2) -1]+nums[x/2])/2.0;
18        }
19        else{
20            ans =nums[x/2];
21        }
22        return ans;
23    }
24}