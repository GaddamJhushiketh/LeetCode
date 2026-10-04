1class Solution {
2    public boolean checkValidString(String s) {
3        int min = 0;
4        int max = 0;
5        for(char ch : s.toCharArray()){
6            if(ch == '('){
7                min++;
8                max++;
9            }
10            else if(ch ==')'){
11                min = Math.max(0,min-1);
12                max--;
13            }
14            else{
15                min = Math.max(0,min-1);
16                max++;
17            }
18            if(max<0){
19                return false;
20            }
21        }
22        return min == 0;
23    }
24}