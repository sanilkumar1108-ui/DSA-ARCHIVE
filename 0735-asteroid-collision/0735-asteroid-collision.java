class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>s = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            boolean isDestroyed = false;
            while(!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0){
                if(Math.abs(asteroids[i]) > s.peek()){
                    s.pop();
                    continue;
                    // s.push(asteroids[i]);
                }else if(Math.abs(asteroids[i]) == s.peek()){
                    s.pop();
                }
                isDestroyed = true;
                break;
            }
            if(!isDestroyed){
                s.push(asteroids[i]);
            }
        }

        int res[] = new int[s.size()];
        for(int i = res.length - 1 ; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }
}