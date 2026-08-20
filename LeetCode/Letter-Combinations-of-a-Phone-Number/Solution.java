1class Solution {
2    public static final String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
3    public List<String> letterCombinations(String digits) {
4        List<String> ans = new ArrayList<>();
5        if(digits == null || digits.length() == 0){
6            return ans;
7        }
8        backtrack(0,digits, new StringBuilder(),ans);
9        return ans;
10    }
11    public static void backtrack(int ind, String dig, StringBuilder path, List<String> ans){
12        if(ind == dig.length()){
13            ans.add(path.toString());
14            return;
15        }
16        String letter = arr[dig.charAt(ind) - '0'];
17        for(char c : letter.toCharArray()){
18            path.append(c);
19            backtrack(ind+1,dig,path,ans);
20            path.deleteCharAt(path.length()-1);
21        }
22    }
23}