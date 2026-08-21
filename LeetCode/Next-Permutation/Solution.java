1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n = nums.length;
4        int i = n-2;
5        while(i>=0 &&nums[i]>=nums[i+1]){
6            i--;
7        }
8        if(i>=0){
9            int j = n-1;
10            while(nums[j]<=nums[i]){
11                j--;
12            }
13            swap(nums,i,j);
14        }
15        reverse(nums,i+1,n-1);
16    }
17    public void swap(int[] nums,int i ,int j){
18        int temp = nums[i];
19        nums[i] = nums[j];
20        nums[j] = temp;
21    }
22    public void reverse(int[] nums,int i ,int j){
23        while(i<j){
24            swap(nums,i++,j--);
25        }
26    }
27}