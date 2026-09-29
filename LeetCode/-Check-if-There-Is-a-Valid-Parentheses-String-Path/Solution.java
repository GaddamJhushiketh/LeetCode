1class Solution {
2    public boolean hasValidPath(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        if((n+m-1)%2!=0){
6            return false;
7        }
8        Boolean[][][] memo = new Boolean[m][n][m+n+1];
9        return dfs(0,0,0,grid,memo);
10    }
11    public static boolean dfs(int r, int c, int count, char[][] g,Boolean[][][] memo){
12        int m = g.length;
13        int n = g[0].length;
14        if(g[r][c] == '('){
15            count++;
16        }
17        else{
18            count--;
19        }
20        if(count <0){
21            return false;
22        }
23        if(r == m-1 && c == n-1){
24            return count == 0;
25        } 
26        if(memo[r][c][count]!=null){
27            return memo[r][c][count];
28        }
29        boolean down = false;
30        boolean right = false;
31        if(r+1<m){
32            down = dfs(r+1,c,count,g,memo);
33        }
34        if(!down && c+1<n){
35            right = dfs(r,c+1,count,g,memo);
36        }
37        return memo[r][c][count] = down || right;
38    }
39}