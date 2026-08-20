1class Solution {
2    public String convert(String s, int numRows) {
3        if(numRows ==1 ||numRows >= s.length()){
4            return s;
5        }
6        StringBuilder[] row = new StringBuilder[numRows];
7        for(int i =0;i<numRows;i++){
8            row[i] = new StringBuilder();
9        }
10        int curr =0;
11        boolean flag = false;
12        for(char ch : s.toCharArray()){
13            row[curr].append(ch);
14            if(curr == 0 || curr == numRows -1){
15                flag = !flag;
16            }
17            curr += flag ? 1: -1; 
18        }
19        StringBuilder ans = new StringBuilder();
20        for(StringBuilder r : row){
21            ans.append(r);
22        }
23        return ans.toString();
24    }
25}