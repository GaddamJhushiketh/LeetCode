int maxNumberOfFamilies(int n, vector<vector<int>>& A) {
    ranges::sort(A);
    int res = n << 1;
    int s = A.size(), m = 0;
    for (int i = 0; i < s; i++) {
        m |= (1 << A[i][1]);
        if (i == s - 1 || A[i][0] != A[i + 1][0]) {
            int c = !(m & 0x3C) + !(m & 0x3C0);
            c += !c * !(m & 0xF0);
            res -= 2 - c;
            m = 0;
        }
    }
    return res;
}