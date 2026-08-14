1class Solution {
2    public static int expand(String s, int l,int r){
3        while(l>=0 && r<s.length()&& s.charAt(l) == s.charAt(r)){
4            l--;
5            r++;
6        }
7        return r-l-1;
8    }
9    public String longestPalindrome(String s) {
10        if(s == null || s.length()<1){
11            return "";
12        }
13        int start =0, end =0;
14        for(int i =0;i<s.length();i++){
15            int l1 = expand(s,i,i);
16            int l2 = expand(s,i,i+1);
17            int len = Math.max(l1,l2);
18            if(len>end - start){
19                start = i-(len-1)/2;
20                end = i+len/2;
21            }
22        }
23        return s.substring(start,end+1);
24    }
25}