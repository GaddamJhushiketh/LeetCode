1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int num:nums){
5            set.add(num);
6        }
7        int multiple = k;
8        while(set.contains(multiple)){
9            multiple += k;
10        }
11        return multiple;
12    }
13}