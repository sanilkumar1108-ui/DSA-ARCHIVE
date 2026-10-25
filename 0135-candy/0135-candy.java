class Solution {
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);

        for(int i = 1; i < num.length; i++){
            if(ratings[i] > ratings[i - 1]){
                num[i] = num[i - 1] + 1;
            }
        }

        for(int i = num.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                num[i] = Math.max(num[i], num[i + 1] + 1);
            }
        }

        int sum = 0;
        for(int i : num){
            sum += i;
        }

        return sum;
    }
}