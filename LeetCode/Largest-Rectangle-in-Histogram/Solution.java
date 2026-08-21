1class Solution {
2    public int[] nsei(int[] h){
3        int n = h.length;
4        int ans[] = new int[n];
5        Arrays.fill(ans,n);
6        Stack<Integer> st = new Stack<>();
7        for(int i=0;i<n;i++){
8            while(!st.isEmpty() && h[i]<h[st.peek()]){
9                ans[st.peek()] = i;
10                st.pop();
11            }
12            st.push(i);
13        }
14        return ans;
15    }
16    public int[] psei(int[] h){
17        int n = h.length;
18        int ans[] = new int[n];
19        Arrays.fill(ans,-1);
20        Stack<Integer> st = new Stack<>();
21        for(int i =n-1;i>=0;i--){
22            while(!st.isEmpty() && h[i]<h[st.peek()]){
23                ans[st.peek()] = i;
24                st.pop();
25            }
26            st.push(i);
27        }
28        return ans;
29    }
30    public int largestRectangleArea(int[] h) {
31        int max = Integer.MIN_VALUE;
32        int n = h.length;
33        int[] a = nsei(h);
34        int[] b = psei(h);
35        for(int i=0;i<n;i++){
36            int w = a[i]-b[i]-1;
37            max = Math.max(max,h[i]*w);
38        }
39        return max;
40    }
41}