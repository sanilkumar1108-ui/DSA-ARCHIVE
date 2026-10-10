class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diff = new int[n];
        
        // 1. Calculate absolute differences and track the maximum
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // If max difference is 0, the sum of squares is already 0
        if (maxDiff == 0) return 0;

        // 2. Count frequency of each difference value
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        long k = (long) k1 + k2;

        // 3. Batch reduce from the largest difference downwards
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;

            if (k >= count[d]) {
                // Shift all count[d] items down to d - 1
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                // Only k items can be shifted down to d - 1
                count[d] -= (int) k;
                count[d - 1] += (int) k;
                k = 0;
            }
        }

        // 4. Calculate final sum of squares (using 64-bit long)
        long minSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                minSum += (long) count[d] * (long) d * d;
            }
        }

        return minSum;
    }
}