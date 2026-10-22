class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int start = 0;
        while(nums[start]!=0){
            start++;
        }
        boolean acs = true;
        boolean des = true;
        for(int i =1;i<n;i++){
            int val = nums[(start+i)%n];
            if(val!=i){
                acs = false;
            }
            if(val!=n-i){
                des = false;
            }
            if(!acs&&!des){
                return -1;
            }
        }
        if(acs){
            return Math.min(start,n-start+2);
        }
        return Math.min(n-start,start+2);
    }
}