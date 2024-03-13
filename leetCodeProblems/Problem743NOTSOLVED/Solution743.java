package Problem743NOTSOLVED;

import java.util.*;
public class Solution743 {

    public static void main(String[] args) {
        int[][] times = new int[][]{{1,2, 1}, {2,1,3}};
        int n = 4;
        int k = 2;
        Solution743 sol = new Solution743();
        System.out.println(sol.networkDelayTime(times, n, k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[k-1] = 0;
        visited[k-1] = true;

        Arrays.sort(times, (a, b) -> Integer.compare(a[2], b[2])); // sort array by weight
        int[] lastElement = times[times.length - 1];
        int i= 0;
        while (true){
            System.out.println(i);
            boolean changed = false;
            if(visited[times[i][0]-1] && ((times[i][2] + distance[times[i][0]-1]) < distance[times[i][1]-1] || distance[times[i][1]-1] ==-1)  ){
                visited[times[i][1]-1] = true;
                distance[times[i][1]-1] = distance[times[i][0]-1] + times[i][2];
                changed = true;
            }
            if (times[i] == lastElement){
                break;
            }
            if(changed){
                i = 0;
                continue;
            }
            i++;
        }

        int max = 0;
        for (i = 0; i < n; i++){
            if (!visited[i]){
                System.out.println("Not all nodes are visited " + (i+1));
                return -1;
            }
            if (distance[i] > max){
                max = distance[i];
            }
        }

        return max;
    }



}