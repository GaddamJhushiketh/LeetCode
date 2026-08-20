1class Solution {
2    public String intToRoman(int num) {
3        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
4        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
5        StringBuilder romen = new StringBuilder();
6        for(int i=0;i<val.length;i++){
7            while(num >=val[i]){
8                num -= val[i];
9                romen.append(symbols[i]);
10            }
11        }
12        return romen.toString();
13    }
14}