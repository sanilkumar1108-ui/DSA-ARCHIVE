class Solution {
    public int findMin(int[] nums) {
        int st = 0; int end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(st <= end){
            int mid = st + (end - st)/2;
            min = Math.min(min, nums[mid]);

            if(nums[mid] < nums[end]){
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return min;
        
    }

}