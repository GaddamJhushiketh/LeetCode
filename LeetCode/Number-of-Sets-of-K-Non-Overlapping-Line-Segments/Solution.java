1class Solution {
2    private static final long MOD = 1000000007L;
3    private long quickPow(long a, long e) {
4        long result = 1;
5        while (e > 0) {
6            if ((e & 1) != 0) result = (result * a) % MOD;
7            a = (a * a) % MOD;
8            e >>= 1;
9        }
10        return result;
11    }
12    public int numberOfSets(int n, int k) {
13        int m = 2 * k;
14        long numerator = 1, denominator = 1;
15        for (int i = 1; i <= m; i++) {
16            numerator = (numerator * (n + k - i)) % MOD;
17            denominator = (denominator * i) % MOD;
18        }
19        return (int) ((numerator * quickPow(denominator, MOD - 2)) % MOD);
20    }
21}