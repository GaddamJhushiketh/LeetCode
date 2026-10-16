class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans =0;
        int n = nums.size();
        for(int i =0;i<n;i++){
            HashSet<Integer> dic = new HashSet<>();
            for(int j = i;j<n;j++){
                dic.add(nums.get(j));
                ans+=dic.size()*dic.size();
            }
        }
        return ans;
    }
}