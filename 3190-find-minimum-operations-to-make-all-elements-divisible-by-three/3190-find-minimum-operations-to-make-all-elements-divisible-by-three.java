class Solution {
    public int minimumOperations(int[] nums) {
        int total = 0;
        for(int num : nums){
            if(num %3 == 0) continue;
            total++;
        }
        return total;
    }
}