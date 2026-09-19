1class Solution {
2    public List<Integer> getRow(int n) {
3        List<Integer> row = new ArrayList<>();
4        row.add(1);
5        for (int i = 1; i <= n; i++) {
6            row.add(1);
7            for (int j = i - 1; j > 0; j--) {
8                row.set(j, row.get(j) + row.get(j - 1));
9            }
10        }
11        return row;
12    }
13}