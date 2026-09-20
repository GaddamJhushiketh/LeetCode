1class Solution {
2    public int reverseDegree(String s) {
3        int ans =0;
4        for(int i =0;i<s.length();i++){
5            ans+=(i+1)*(26-(s.charAt(i)-'a'));
6        }
7        return ans;
8    }
9}