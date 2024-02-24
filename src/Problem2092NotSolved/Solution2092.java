package Problem2092NotSolved;

import java.util.*;


public class Solution2092 {
    public static void main(String[] args) {
        Solution2092 solution = new Solution2092();
        int[][] meetings = {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}};
        int n = 4;
        int firstPerson = 3;
        System.out.println(solution.findAllPeople(n, meetings, firstPerson)); // output should be [0, 1, 3]
        meetings = new int[][]{{1, 4, 3}, {0, 4, 3}};
        n = 5;
        firstPerson = 3;
        System.out.println(solution.findAllPeople(n, meetings, firstPerson)); // output should be [0, 1, 3, 4]

    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        //create an arraylist of people who knows secret
        HashSet<Integer> people = new HashSet<>();
        //add peoples who know the secret
        people.add(0);
        people.add(firstPerson);


        //quicksort the meetings by time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        //create an arraylist for listing to meeting times
        ArrayList<int[]> meetingList = new ArrayList<>();

        //add the meetings to the meetingList
        meetingList.addAll(Arrays.asList(meetings));


        //for meetings.length times
        //if meeting[0] or meeting[1] is in the people list, add the other person to the list if both of them are in or not in the list the do nothing

        for (int i = 0, j = 0; i < meetings.length; i++, j++) {
            System.out.print("i: " + i + "  old j: " + j);
            j -= checkMeeting(j, meetingList, people);
            System.out.println("  new j: " + j);
        }

        return new ArrayList<>(people);
    }

    private int checkMeeting(int i, ArrayList<int[]> list, HashSet<Integer> people) {
        boolean first = people.contains(list.get(i)[0]), second = people.contains(list.get(i)[1]), isAdded = true;
        if (first && !second) {
            people.add(list.get(i)[1]);
        } else if (!first && second) {
            people.add(list.get(i)[0]);
        } else if (!first) {
            isAdded = false;
        }

        if (isAdded) {
            int time = list.get(i)[2];
            list.remove(i);
            if (i > 0)
                if (time == list.get(i - 1)[2])
                    return checkMeeting(i - 1, list, people) + 1;
            return 1;
        }
        return 0;
    }


}
