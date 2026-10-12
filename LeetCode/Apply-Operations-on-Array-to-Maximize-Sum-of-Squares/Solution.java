1class Solution {
2    public final int MOD = 1000000007;
3    public int maxSum(List<Integer> nums, int k) {
4        int[] cnt = new int[30];
5        for(int num : nums){
6            for(int i = 0; i < 30; i++){
7                if((num&(1<<i)) != 0){
8                    cnt[i]++;
9                }
10            }
11        }
12        long res = 0;
13        for(int i = 0; i < k; i++) {
14            long cur = 0;
15            for(int j = 29; j >= 0; j--) {
16                if(cnt[j] > 0){
17                    cur |= 1L << j;
18                    cnt[j]--;
19                }
20            }
21            res = (res + cur * cur) % MOD;
22        }
23        return (int) res;
24    }
25}