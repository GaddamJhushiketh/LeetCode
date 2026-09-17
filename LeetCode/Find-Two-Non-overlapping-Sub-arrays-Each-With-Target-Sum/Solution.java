1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        Map<Integer,Integer>pos = new HashMap<>();
4        pos.put(0, -1);
5        int n = arr.length;
6        int s = 0;
7        int ans = n + 1;
8        int minL = n;
9        for(int i=0;i<n;i++){
10            s+=arr[i];
11            if(pos.containsKey(s-target)){
12                int j=pos.get(s - target);
13                int len=i-j;
14                ans = Math.min(ans,len+(j==-1?n:arr[j]));
15                minL = Math.min(minL,len);
16            }
17            arr[i] = minL;
18            pos.put(s, i);
19        }
20        return ans == n + 1 ? -1 : ans;
21    }
22}