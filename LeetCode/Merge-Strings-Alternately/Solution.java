1class Solution {
2    public String mergeAlternately(String word1, String word2) {
3        int n = word1.length();
4        int m = word2.length();
5        StringBuilder str = new StringBuilder();
6        int i =0,j=0;
7        while(i<n &&j<m){
8            if(i<=j){
9                str.append(word1.charAt(i));
10                i++;
11            }
12            else{
13                str.append(word2.charAt(j));
14                j++;
15            }
16        }
17        while(i<n){
18            str.append(word1.charAt(i++));
19        }
20        while(j<m){
21            str.append(word2.charAt(j++));
22        }
23        return str.toString();
24    }
25}