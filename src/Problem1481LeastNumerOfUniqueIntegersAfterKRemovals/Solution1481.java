package Problem1481LeastNumerOfUniqueIntegersAfterKRemovals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution1481 {
    public static void main(String[] args) {
        int[] arr = {2,4,1,8,3,5,1,3};
        int k = 3;
        Solution1481 solution = new Solution1481();
        System.out.println(solution.findLeastNumOfUniqueInts(arr, k));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        Integer[] allNumbers = set.toArray(new Integer[0]);
        int [] count = new int[allNumbers.length];
        for (int i = 0; i < allNumbers.length; i++) {
            count[i] = map.get(allNumbers[i]);
        }
        Arrays.sort(count);
        System.out.println(Arrays.toString(count));
        System.out.println(map.toString());
        System.out.println(set.toString());

        int j =0;
        for (int i =0; i<k;i++){
            if(count[j] == 0){
                j++;
            }
            count[j]--;
        }

        System.out.println("\n"+Arrays.toString(count));

        if(count[j] == 0){
            j++;
        }
        return count.length - j ;
    }
}
