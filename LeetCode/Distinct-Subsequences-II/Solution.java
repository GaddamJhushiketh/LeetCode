1class Solution {
2    public int distinctSubseqII(String s) {
3        int MOD = 1000000007;
4        long dp = 1;
5        long[] last = new long[26];
6        for(char ch : s.toCharArray()){
7            int c = ch - 'a';
8            long newDp = (2*dp)%MOD;
9            newDp = (newDp-last[c]+MOD)%MOD;
10            last[c] = dp;
11            dp = newDp;
12        }
13        return (int)((dp-1+MOD)%MOD);
14    }
15}