1class Solution {
2    public boolean winnerSquareGame(int n) {
3        boolean arr[] = new boolean[n+1];
4        for(int i =1;i<=n;i++){
5            for(int j =1;j*j<=i;j++){
6                if(!arr[i-j*j]){
7                    arr[i] = true;
8                    break;
9                }
10            }
11        }
12        return arr[n];
13    }
14}