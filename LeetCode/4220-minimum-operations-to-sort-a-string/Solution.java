class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char mx = 'a',mi ='z';
        boolean sort = true;
        for(int i =0;i<n;i++){
        mx = (char)(Math.max(mx,s.charAt(i)));
        mi = (char)(Math.min(mi,s.charAt(i)));
        if(i>0 && s.charAt(i-1)>s.charAt(i)){
            sort = false;
        }
        }
        if(sort){
            return 0;
        }
        if(n==2){
            return -1;
        }
        if(s.charAt(0) == mi || s.charAt(n-1) == mx){
            return 1;
        }
        for(int i =1;i<n-1;i++){
            if(s.charAt(i) == mi || s.charAt(i) == mx){
                return 2;
            }
        }
        return 3;
    }
}