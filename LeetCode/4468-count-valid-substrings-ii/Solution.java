class Solution {
    public long countValidSubstrings(String s) {
        String temp = s;
        int n = s.length();
        long ans =0;
        int ca =-1;
        int max = -1;
        long l =0;
        for(int r=0;r<n;r++){
            char c = temp.charAt(r);
            if(c == 'a'){
                ca =r;
            }
            else if(c == 'b'){
                if(ca != -1){
                    max = Math.max(max,ca);
                }
            }
            else if(c =='c'){
                if(max !=-1){
                    l = Math.max(l,max+1);
                }
            }
            ans +=(r-l+1);
        }
        return ans;
    }
}