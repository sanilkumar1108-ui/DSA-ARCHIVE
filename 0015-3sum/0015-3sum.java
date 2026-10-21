class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int st = i + 1, end = nums.length - 1;
            while(st < end){
                if(nums[st] + nums[end] == -1 * nums[i]){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[st]);
                    res.add(nums[end]);
                    main.add(res);
                    st++;
                    end--;
                    while(st < end && nums[st] == nums[st - 1]){
                        st++;
                    }
                    while(st < end && nums[end] == nums[end + 1]){
                        end--;
                    }
                }else if(nums[st] + nums[end] + nums[i] > 0){
                    end--;
                }else{
                    st++;
                }
            }
        }
        return main;
    }
}