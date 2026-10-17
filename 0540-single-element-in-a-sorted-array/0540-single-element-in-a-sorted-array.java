class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];
        int st = 1, end = n - 2,  mid = 0;
        while(st <= end){
            mid = st + (end - st)/2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                break;
            }
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid - 1]){
                    end = mid - 1;
                }else{
                    st = mid + 1;
                }
            }else{
                if(nums[mid] == nums[mid - 1]){
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return nums[mid];
    }
}