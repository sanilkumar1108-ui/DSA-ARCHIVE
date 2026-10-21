class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        maxSum = Math.max(maxSum, sum);
        int j = 0;
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[j];
            j++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum/k;
    }
}