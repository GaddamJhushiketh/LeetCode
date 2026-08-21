1class Solution {
2    public String minWindow(String s, String t) {
3        if(s.length() < t.length()) return "";
4        Map<Character, Integer> map = new HashMap<>();
5        for(int i=0;i<t.length();i++){
6            char ch = t.charAt(i);
7            map.put(ch,map.getOrDefault(ch,0)+1);
8        }
9        int stillneed = map.size();
10        int j=0;
11        int start=0,len=Integer.MAX_VALUE;
12        for(int i =0; i < s.length() ; i++){
13            char ch = s.charAt(i);
14            if(map.containsKey(ch)){
15                map.put(ch,map.get(ch)-1);
16                if(map.get(ch) == 0){
17                    stillneed--;
18                }
19            }
20            while(stillneed == 0){
21                // shrinking the window
22                if(i-j+1 < len){
23                    len = i-j+1;
24                    start = j;
25                }
26                char leftChar = s.charAt(j);
27                if(map.containsKey(leftChar)){
28                    map.put(leftChar, map.get(leftChar) + 1);
29                    if(map.get(leftChar) > 0)
30                        stillneed++;
31                    }
32                j++;
33            }
34        }
35        String str = (len == Integer.MAX_VALUE) ? "":s.substring(start,start+len);
36        return str;
37    }
38}