package Problem630NOTSOLVED;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution630 {
    public static void main(String[] args) {
        Solution630 solution630 = new Solution630();
        int[][] courses = {{5, 5}, {4, 6}, {2, 6}};
        System.out.println(solution630.scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        // [duration][lastDay]
        courses = removeNonOptimalCourses(courses);
        sortByLastDay(courses);
        int totalDays,maxDays = 0;
        boolean isOK;
        for (int i = ((int) Math.pow(2, courses.length) - 1); i >= 0; i--) {
            totalDays = 0;
            isOK = true;
            String binary = makeBinary(i, courses.length);
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    totalDays += courses[j][0];
                    if (totalDays > courses[j][1]) {
                        isOK = false;
                        break;
                    }
                }
            }
            if (isOK) {
                int days = 0;
                for (int j = 0; j < courses.length; j++) {
                    if (binary.charAt(j) == '1') {
                        days++;
                    }
                }
                if (days > maxDays) {
                    maxDays = days;
                }
            }
        }
        return maxDays;
    }

    /**
     * Removes courses that have duration greater than last day
     *
     * @return courses that have duration less than or equal to last day
     */
    public int[][] removeNonOptimalCourses(int[][] courses) {
        List<int[]> list = new java.util.ArrayList<>(List.of(courses));
        list.removeIf(course -> course[0] > course[1]);
        return list.toArray(new int[0][]);
    }

    private void sortByLastDay(int[][] array) {
        Arrays.sort(array, Comparator.comparingInt(row -> row[1]));
    }

    private String makeBinary(int number, int length) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(number));
        while (binary.length() < length) {
            binary.insert(0, "0");
        }
        return binary.toString();
    }

    public int scheduleCourse2(int[][] courses) {
        // [duration][lastDay]
        courses = removeNonOptimalCourses(courses);
        sortByLastDay(courses);
        int totalDays;
        boolean isOK;
        for(int i = 0;i<courses.length;i++){
            ArrayList<int[][]> combinations = combinations(courses,i);
            for(int[][] combination:combinations){
                totalDays = 0;
                isOK = true;
                for(int[] course:combination){
                    totalDays += course[0];
                    if(totalDays > course[1]){
                        isOK = false;
                        break;
                    }
                }
                if(isOK){
                    return combination.length;
                }
            }
        }
        return 0;
    }

    public ArrayList<int[][]> combinations(int[][] array, int combinationNumber) {
        ArrayList<int[][]> result = new ArrayList<>();
        generateCombinations(array, combinationNumber, 0, new int[array.length], result);
        for (int[][] combination : result) {
            for (int[] row : combination) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
        }
        return result;
    }

    private void generateCombinations(int[][] array, int combinationNumber, int index, int[] combination, ArrayList<int[][]> result) {
        if (index == array.length) {
            if (countSelectedElements(combination) == combinationNumber) {
                int[][] newCombination = createCombination(array, combination);
                result.add(newCombination);
            }
            return;
        }

        // Include current row in the combination
        combination[index] = 1;
        generateCombinations(array, combinationNumber, index + 1, combination, result);

        // Exclude current row from the combination
        combination[index] = 0;
        generateCombinations(array, combinationNumber, index + 1, combination, result);
    }

    private int countSelectedElements(int[] combination) {
        int count = 0;
        for (int value : combination) {
            count += value;
        }
        return count;
    }

    private int[][] createCombination(int[][] array, int[] combination) {
        int selectedRowCount = countSelectedElements(combination);
        int[][] newCombination = new int[selectedRowCount][];
        int newIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (combination[i] == 1) {
                newCombination[newIndex] = array[i].clone();
                newIndex++;
            }
        }
        return newCombination;
    }


}
