1class Solution {
2    public int maxDepth(String s) {
3        int count = 0;
4        int max = 0;
5        for(char ch : s.toCharArray()){
6            if(ch == '('){
7                count++;
8                max = Math.max(max, count);
9            } 
10            else if(ch == ')'){
11                count--;
12            }
13        }
14        return max;
15    }
16}