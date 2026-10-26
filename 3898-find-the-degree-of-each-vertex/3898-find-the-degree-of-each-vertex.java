class Solution {
    public int[] findDegrees(int[][] matrix) {
        int arr[] = new int[matrix.length];
       int n = matrix.length;
       for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(matrix[i][j] == 1){
                arr[i]++;
            }
        }
       }
       return arr; 
    }
}