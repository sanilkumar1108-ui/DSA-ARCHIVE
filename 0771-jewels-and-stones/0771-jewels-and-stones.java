class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        boolean arr[] = new boolean[128];
        for(int i = 0; i < jewels.length(); i++){
            char c = jewels.charAt(i);
            arr[c] = true;
        }

        for(int i = 0; i < stones.length(); i++){
            int c = stones.charAt(i);
            if(arr[c]){
                count++;
            }
        }
        return count;
    }
}