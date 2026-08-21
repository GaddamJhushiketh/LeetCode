1class MedianFinder {
2    PriorityQueue<Integer> left;
3    PriorityQueue<Integer> right;
4    public MedianFinder() {
5        left = new PriorityQueue<>(Collections.reverseOrder());
6        right = new PriorityQueue<>();
7    }
8    public void addNum(int num) {
9        left.add(num);
10        right.add(left.remove());
11        if(right.size()>left.size()){
12            left.add(right.remove());
13        }
14    }
15    public double findMedian() {
16        if(left.size() == right.size()){
17            return(left.peek() + right.peek())/2.0;
18        }
19        return left.peek();
20    }
21}
22
23/**
24 * Your MedianFinder object will be instantiated and called as such:
25 * MedianFinder obj = new MedianFinder();
26 * obj.addNum(num);
27 * double param_2 = obj.findMedian();
28 */