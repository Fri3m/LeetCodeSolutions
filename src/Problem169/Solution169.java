package Problem169;

import java.util.Arrays;

public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int[] nums = {3, 2, 3, 3, 4};
        System.out.println(solution169.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        return boyerMooreSolution(nums);
    }
    private int boyerMooreSolution(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
