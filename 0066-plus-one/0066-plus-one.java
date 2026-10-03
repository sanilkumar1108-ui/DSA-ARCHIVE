class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse the array from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // No carry means we can stop and return the result
                return digits;
            }
            // If the digit is 9, it becomes 0 and the loop continues to carry the 1
            digits[i] = 0;
        }
        
        // If we exit the loop, it means the number was something like 99, 999, etc.
        // We need a new array with one extra space.
        int[] result = new int[digits.length + 1];
        result[0] = 1; // The rest of the array defaults to 0 in Java
        
        return result;
    }
}