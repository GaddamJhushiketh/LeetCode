1class Solution {
2    public String gcdOfStrings(String str1, String str2) {
3        if(!(str1+str2).equals(str2+str1)){
4            return "";
5        }   
6        int gcdlen = gcd(str1.length(),str2.length());
7        return str1.substring(0,gcdlen);
8    }
9    public int gcd(int a,int b){
10        return b == 0 ? a:gcd(b,a%b);
11    }
12}