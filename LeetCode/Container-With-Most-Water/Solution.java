1class Solution {
2    public int maxArea(int[] h) {
3        int l =0;
4        int r = h.length-1;
5        int max =0;
6        while(l<r){
7            int w = r-l;
8            int he = Math.min(h[l],h[r]);
9            int area = he*w;
10            max = Math.max(max,area);
11            if(h[l]<h[r]){
12                l++;
13            }
14            else{
15                r--;
16            }
17        }
18        return max;
19    }
20}