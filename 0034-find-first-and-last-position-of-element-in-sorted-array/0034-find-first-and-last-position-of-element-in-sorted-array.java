class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = find(nums, target, false);
        return new int[]{first, last};
    }
    private int find(int[] nums, int target, boolean isFirst){
        int l = 0, r = nums.length - 1, bound = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                bound = mid;
                if(isFirst){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return bound;
    }
}