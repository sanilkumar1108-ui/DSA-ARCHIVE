class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        
        // dp[r] stores the number of subarrays ending at the previous index with product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int mod = num % k;

            // 1. A new subarray consisting solely of nums[i]
            nextDp[mod]++;

            // 2. Extend all subarrays ending at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newMod = (int) ((1L * r * mod) % k);
                    nextDp[newMod] += dp[r];
                }
            }

            // 3. Add counts of all subarrays ending at the current index to the answer
            for (int r = 0; r < k; r++) {
                ans[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return ans;
    }
}