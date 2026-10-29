class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && el2 != nums[i]){
                count1++;
                el1 = nums[i];
            }else if(count2 == 0 && el1 != nums[i]){
                count2++;
                el2 = nums[i];
            }else if(nums[i] == el1){
                count1++;
            }else if(nums[i] == el2){
                count2++;
            }else{
                count1--; count2--;
            }
        }
        List<Integer> ls = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == el1) count1++;
            if(nums[i] == el2) count2++;
        }
        if(count1 >= nums.length/3 + 1) ls.add(el1);
        if(count2 >= nums.length/3 + 1) ls.add(el2);
        return ls;
    }
}