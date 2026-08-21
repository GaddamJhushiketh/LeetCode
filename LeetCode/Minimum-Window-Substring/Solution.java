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
21                if(i-j+1 < len){
22                    len = i-j+1;
23                    start = j;
24                }
25                char leftChar = s.charAt(j);
26                if(map.containsKey(leftChar)){
27                    map.put(leftChar, map.get(leftChar) + 1);
28                    if(map.get(leftChar) > 0)
29                        stillneed++;
30                    }
31                j++;
32            }
33        }
34        String str = (len == Integer.MAX_VALUE) ? "":s.substring(start,start+len);
35        return str;
36    }
37}