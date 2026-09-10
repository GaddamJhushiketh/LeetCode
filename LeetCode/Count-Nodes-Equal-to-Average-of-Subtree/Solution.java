1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int ans =0;
18    public int averageOfSubtree(TreeNode root) {
19        dfs(root);
20        return ans;
21    }
22    public int[] dfs(TreeNode root) {
23        if(root == null){
24            return new int[]{0, 0};
25        }
26        int[] left = dfs(root.left);
27        int[] right = dfs(root.right);
28        int sum = left[0] + right[0] + root.val;
29        int count = left[1] + right[1] + 1;
30        if(sum/count == root.val){
31            ans++;
32        }
33        return new int[]{sum, count};
34    }
35}