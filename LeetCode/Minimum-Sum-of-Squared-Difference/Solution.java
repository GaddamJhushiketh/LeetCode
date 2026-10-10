1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int n = nums1.length;
4        long total = (long) k1+k2;
5        int max = 0;
6        long[] count = new long[100005];
7        for(int i=0;i<n;i++){
8            int diff = Math.abs(nums1[i] - nums2[i]);
9            count[diff]++;
10            if(diff> max){
11                max = diff;
12            }
13        }
14        for(int d = max;d>0 && total>0;d--){
15            if(count[d]>0){
16                long temp = Math.min(total,count[d]);
17                count[d]-=temp;
18                count[d-1]+=temp;
19                total-=temp;
20            }
21        }
22        long min =0;
23        for(int d =0;d<=max;d++){
24            if(count[d]>0){
25                min+=count[d]*(long)d*d;
26            }
27        }
28        return min;
29    }
30}