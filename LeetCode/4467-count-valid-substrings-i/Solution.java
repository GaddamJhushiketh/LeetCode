class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans =0;
        int l =0;
        for(int r = 0;r<n;r++){
            if(r >=2 && s.charAt(r-2) == 'a' && s.charAt(r-1) == 'b' && s.charAt(r) == 'c'){
                l = Math.max(l,r-1);
            }
            ans +=(r-l+1);
        }
        return ans;
    }
}