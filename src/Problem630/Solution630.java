package Problem630;


import java.util.List;

public class Solution630 {
    public static void main(String[] args) {
        Solution630 solution630 = new Solution630();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        courses = solution630.removeNonOptimalCourses(courses);
    }
    public int scheduleCourse(int[][] courses) {
        // [duration][lastDay]
        courses = removeNonOptimalCourses(courses);
        int result;
        for (result = courses.length; result > 0; result--) {

        }

        return result;
    }
    public int[][] removeNonOptimalCourses(int[][] courses) { // removes courses that durations are greater than last day
        List<int[]> list = new java.util.ArrayList<>(List.of(courses));
        list.removeIf(course -> course[0] > course[1]);
        return list.toArray(new int[0][]);
    }
}
