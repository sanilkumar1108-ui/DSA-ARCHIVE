class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 1. Find the closest x and y on the rectangle to the circle's center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // 2. Calculate the distance between the circle's center and this closest point
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        // 3. If the squared distance is <= radius squared, they overlap
        return (distX * distX) + (distY * distY) <= radius * radius;
    }
}