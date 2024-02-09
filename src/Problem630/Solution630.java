package Problem630;


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
}
