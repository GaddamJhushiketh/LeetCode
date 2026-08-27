1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int n = s.length();
4        int[] freq = new int[26];
5        for (char c : s.toCharArray()) {
6            freq[c - 'a']++;
7        }
8        StringBuilder prefix = new StringBuilder();
9        for (int i = 0; i < n; i++) {
10            int x = target.charAt(i) - 'a';
11            if (freq[x] > 0) {
12                freq[x]--;
13                prefix.append((char) ('a' + x));
14                continue;
15            }
16            for (int c = x + 1; c < 26; c++) {
17                if (freq[c] > 0) {
18                    prefix.append((char) ('a' + c));
19                    freq[c]--;
20                    addSorted(prefix, freq);
21                    return prefix.toString();
22                }
23            }
24            break;
25        }
26        for (int i = prefix.length() - 1; i >= 0; i--) {
27            int current = prefix.charAt(i) - 'a';
28            freq[current]++;
29            prefix.deleteCharAt(i);
30            int targetChar = target.charAt(i) - 'a';
31            for (int c = targetChar + 1; c < 26; c++) {
32                if (freq[c] > 0) {
33                    prefix.append((char) ('a' + c));
34                    freq[c]--;
35                    addSorted(prefix, freq);
36                    return prefix.toString();
37                }
38            }
39        }
40        return "";
41    }
42    private void addSorted(StringBuilder sb, int[] freq) {
43        for (int c = 0; c < 26; c++) {
44            while (freq[c] > 0) {
45                sb.append((char) ('a' + c));
46                freq[c]--;
47            }
48        }
49    }
50}