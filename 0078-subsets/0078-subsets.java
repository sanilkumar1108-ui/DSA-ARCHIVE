class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>res = new ArrayList<>();
        helper(nums, ans, res, 0);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>>ans, List<Integer>res , int i){
        int n = nums.length;
        if(i == n){
            ans.add(new ArrayList<>(res));
            return;
        }

        // if yes
        res.add(nums[i]);
        helper(nums,ans,res,i+1);

        // if no
        res.remove(res.size() - 1);
        helper(nums, ans, res, i + 1);

    }
}