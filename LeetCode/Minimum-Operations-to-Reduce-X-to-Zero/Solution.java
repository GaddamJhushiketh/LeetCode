1class Solution {
2    public int minOperations(int[] A, int x) {
3        int k = -x, n = A.length;
4        for (int a : A) k += a;
5        if (k < 0) return -1;
6        if (k == 0) return n;
7        int best = -1, i = 0, s = 0;
8        for (int j = 0; j < n; j++) {
9            s += A[j];
10            while (s > k){
11                s -= A[i++];
12            }
13            if(s == k)
14                best = Math.max(best, j - i + 1);
15        }
16        return best < 0 ? -1 : n - best;
17    }
18}