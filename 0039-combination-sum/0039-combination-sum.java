class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, candidates, target, new ArrayList<>(), result );
        return result;
    }

    public void findCombination(int index, int[] arr, int target, List<Integer> current, List<List<Integer>> result){
        //base case
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(index ==  arr.length || target < 0){
            return;
        }

        //kaam
        if(arr[index] <= target){
            current.add(arr[index]);
            findCombination(index, arr, target - arr[index], current, result );
            current.remove(current.size() - 1);
        }

        findCombination(index + 1, arr, target, current, result);

    }
}