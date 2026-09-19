1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
3        int closestX = Math.max(x1, Math.min(xCenter, x2));
4        int closestY = Math.max(y1, Math.min(yCenter, y2));
5        int dx = xCenter - closestX;
6        int dy = yCenter - closestY;
7        return dx * dx + dy * dy <= radius * radius;
8    }
9}