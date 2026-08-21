1class Solution {
2    public int divide(int dividend, int divisor) {
3        if(dividend==Integer.MIN_VALUE && divisor==-1) {
4            return Integer.MAX_VALUE;
5        }
6        long a = Math.abs((long)dividend);
7        long b = Math.abs((long)divisor);
8        long quotient = 0;
9        while(a>=b){
10            long temp = b;
11            long multiple = 1;
12            while(a>=(temp<<1)){
13                temp <<= 1;
14                multiple <<= 1;
15            }
16            a -= temp;
17            quotient += multiple;
18        }
19        if((dividend<0)!=(divisor<0)){
20            quotient = -quotient;
21        }
22        return (int)quotient;
23    }
24}