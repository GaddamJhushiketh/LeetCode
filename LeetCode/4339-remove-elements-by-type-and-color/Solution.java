class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        List<int[]> list = new ArrayList<>();
        int n = types.length;
        for(int i =0;i<n;i++){
            int t = types[i];
            int c = colors[i];
            int count =1;
            while(!list.isEmpty() && list.get(list.size()-1)[0] == t && list.get(list.size()-1)[1] == c){
                count +=list.remove(list.size()-1)[2];
            }
            list.add(new int[]{t,c,count});
            int req = groupSize[t];
            if(count>= req && count % req == 0){
                list.remove(list.size()-1);
            }
        }
        return list.isEmpty();
    }
}