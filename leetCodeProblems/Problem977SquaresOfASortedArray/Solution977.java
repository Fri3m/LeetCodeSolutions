package Problem977SquaresOfASortedArray;

import java.util.Arrays;

public class Solution977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[]{-1})));
    }
    public int[] sortedSquares(int[] nums) {
        //1ms 46.77 Memory
        int positiveIndex = 0, negativeIndex = 0;
        while (nums[positiveIndex] < 0) {
            positiveIndex++;
            if (positiveIndex == nums.length) {
                break;
            }
        }
        negativeIndex = positiveIndex-1;
        int[] result = new int[nums.length];
        for (int i =0; i<nums.length; i++){
            if(positiveIndex == nums.length){
                result[i] = nums[negativeIndex] * nums[negativeIndex];
                negativeIndex--;
            } else if (negativeIndex == -1) {
                result[i] = nums[positiveIndex] * nums[positiveIndex];
                positiveIndex++;
            } else if (Math.abs(nums[positiveIndex]) < Math.abs(nums[negativeIndex])) {
                result[i] = nums[positiveIndex] * nums[positiveIndex];
                positiveIndex++;
            } else {
                result[i] = nums[negativeIndex] * nums[negativeIndex];
                negativeIndex--;
            }
        }

        return result;
    }

}
