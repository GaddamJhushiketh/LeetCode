class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int n = nums.size();
        for(int len = l;len<=r;len++){
            int curr = 0;
            for(int i =0;i<n;i++){
                curr+=nums.get(i);
                if(i>=len-1){
                    if(curr>0){
                        min = Math.min(min,curr);
                    }
                    curr -= nums.get(i-(len-1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}