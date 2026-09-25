class Solution:
    def braceExpansionII(self, exp: str) -> list[str]:
        stk = [{""}]
        for ch in exp:
            if ch == ",":
                stk[-2:] = [stk[-2] | stk[-1], {""}]
            elif ch == "}":
                stk[-3:] = [{l + r for r in (stk[-1] | stk[-2]) for l in stk[-3]}]
            elif ch == "{":
                stk += [set(), {""}]
            else:
                stk[-1] = {pre + ch for pre in stk[-1]}
        return sorted(stk[-1])