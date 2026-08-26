1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int n = s.length();
4        int left = 0;
5        int ones = 0;
6        String ans = "";
7        for(int right = 0;right<n;right++){
8            if(s.charAt(right) == '1'){
9                ones++;
10            }
11            while(ones > k){
12                if(s.charAt(left) == '1'){
13                    ones--;
14                }
15                left++;
16            }
17            if (ones == k) {
18                while(s.charAt(left) == '0'){
19                    left++;
20                }
21                String current = s.substring(left, right + 1);
22                if(ans.equals("")||current.length()<ans.length()||(current.length() == ans.length()&&current.compareTo(ans) < 0)){
23                    ans = current;
24                }
25            }
26        }
27        return ans;
28    }
29}