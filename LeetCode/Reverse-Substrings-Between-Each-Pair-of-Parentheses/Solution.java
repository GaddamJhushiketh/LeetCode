1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<StringBuilder> st = new Stack<>();
4        StringBuilder str = new StringBuilder();
5        for(char c : s.toCharArray()){
6            if(c == '('){
7                st.push(str);
8                str = new StringBuilder();
9            }
10            else if(c == ')'){
11                str.reverse();
12                StringBuilder temp = str;
13                str = st.pop();
14                str.append(temp);
15            }
16            else{
17                str.append(c);
18            }
19        }
20        return str.toString();
21    }
22}