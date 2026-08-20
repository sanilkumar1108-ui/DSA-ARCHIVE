class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            // Update 'ones' only if the bit is not in 'twos'
            ones = (ones ^ num) & ~twos;
            
            // Update 'twos' only if the bit is not in 'ones'
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}