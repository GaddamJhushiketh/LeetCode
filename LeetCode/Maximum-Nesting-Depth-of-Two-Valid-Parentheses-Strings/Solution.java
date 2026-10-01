class Solution:
    def maxDepthAfterSplit (self, seq: str) -> list[int]:
        op_brac, cl_brac, res = 1, 1, [0] * len(seq)
        for i, ch in enumerate(seq):
            if (ch == '('):
                op_brac ^= 1
                res[i] = op_brac
            elif (ch == ')'):
                cl_brac ^= 1
                res[i] = cl_brac
        return res