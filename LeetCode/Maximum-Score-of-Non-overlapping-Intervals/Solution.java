class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        n = len(intervals)
        order = sorted(range(n), key=lambda i: intervals[i][1])
        rs = [intervals[i][1] for i in order]
        dp = [[(0, ())] * 5 for _ in range(n + 1)]
        for j in range(1, n + 1):
            idx = order[j - 1]
            l, r, w = intervals[idx]
            p = bisect_left(rs, l)
            for k in range(1, 5):
                best = dp[j - 1][k]
                ps, pt = dp[p][k - 1]
                cand = (ps + w, tuple(sorted(pt + (idx,)))) 
                if cand[0] > best[0] or (cand[0] == best[0] and cand[1] < best[1]):
                    best = cand
                dp[j][k] = best
        return list(dp[n][4][1])
