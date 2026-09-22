class Solution {
    public int maxScore(int[] arr, int k) {
    int n = arr.length;
    int sum = 0;
    
    for(int i=0; i < k; i++){
        sum += arr[i];
    }
    int maxScore = sum;
    
    for(int i = 0; i < k ; i++){
        sum -= arr[k - i - 1]; //remove from left
        sum += arr[n - 1 -i]; //add from right
        maxScore = Math.max(maxScore, sum);
    }
    return maxScore;

    }
}