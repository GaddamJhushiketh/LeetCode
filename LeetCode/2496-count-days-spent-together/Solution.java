class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String first = arriveAlice.compareTo(arriveBob)>0 ? arriveAlice : arriveBob;
        String last = leaveAlice.compareTo(leaveBob)<0 ? leaveAlice : leaveBob;
        return  Math.max(0,day(last)-day(first)+1);
    }
    public static final int[] before = {0,31,28,31,30,31,30,31,31,30,31,30};
    static {
        Arrays.parallelPrefix(before,Integer::sum);
    }
        public static int day(String m){
            return before[Integer.parseInt(m.substring(0,2))-1] + Integer.parseInt(m.substring(3));
        }
}