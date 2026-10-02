class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];

        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                neg[a++] = nums[i];
            }else{
                pos[b++] = nums[i];
            }
        }

        int idx = 0, c = 0;
        while(idx < nums.length){
            nums[idx] = pos[c];
            nums[idx + 1] = neg[c];
            idx = idx + 2;
            c++;
        }
        return nums;
    }
}