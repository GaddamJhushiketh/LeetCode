1class Solution {
2    public int myAtoi(String s){
3        if(s == null || s.length() == 0) return 0;
4        int i = 0, n = s.length();
5        while(i < n && s.charAt(i) == ' '){
6            i++;
7        }
8        if(i == n) return 0;
9        int sign = 1;
10        if(s.charAt(i) == '+'){
11            i++;
12        } 
13        else if(s.charAt(i) == '-'){
14            sign = -1;
15            i++;
16        }
17        long result = 0;
18        while(i < n && Character.isDigit(s.charAt(i))){
19            result = result * 10 + (s.charAt(i) - '0');
20            if(sign == 1 && result > Integer.MAX_VALUE)
21                return Integer.MAX_VALUE;
22            if(sign == -1 && -result < Integer.MIN_VALUE)
23                return Integer.MIN_VALUE;
24            i++;
25        }
26        return (int)(sign * result);
27    }
28}