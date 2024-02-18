package Problem743NOTSOLVED;

import java.util.*;

public class Solution743 {
    public static void main(String[] args) {
        int[][] times = new int[][]{{1, 2, 1}};
        System.out.println("Answer is " + new Solution743().networkDelayTime(times, 2, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adjMatrix = createAdjMatrix(times, n);
        int[] ways = findMinWays(adjMatrix, k - 1);
        Arrays.sort(ways);
        System.out.println(Arrays.toString(ways));
        if (ways.length > 1)
            if (ways[0] == -1)
                return -1;
        return ways[ways.length - 1];
    }

    private int[][] createAdjMatrix(int[][] times, int n) {
        int[][] adjMatrix = new int[n][n];
        for (int[] arr : adjMatrix) {
            Arrays.fill(arr, -1);
        }
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];
            if (adjMatrix[source - 1][destination - 1] == -1 || weight < adjMatrix[source - 1][destination - 1])
                adjMatrix[source - 1][destination - 1] = weight;
        }
        return adjMatrix;
    }

    private int[] findMinWays(int[][] adjMatrix, int key) {
        int[] ways = new int[adjMatrix.length];
        Arrays.fill(ways, -1);
        ways[key] = 0;
        boolean[] visited = new boolean[adjMatrix.length];
        visited[key] = true;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (visited[j]) {
                    for (int k = 0; k < adjMatrix.length; k++) {
                        if (!visited[k] && adjMatrix[j][k] != -1) {
                            System.out.println("i = " + i + " Adding edge from " + j + " to " + k + " with weight " + (adjMatrix[j][k] + ways[j]));
                            edges.add(new int[]{j, k, adjMatrix[j][k] + ways[j]});
                        }
                    }
                }
            }
            edges.sort(Comparator.comparingInt(arr -> arr[2]));
            if (edges.isEmpty()) {
                break;
            }
            int[] added = edges.get(0);
            visited[added[1]] = true;
            ways[added[1]] = added[2];
            edges.clear();

            System.out.println("Selected edge from " + added[0] + " to " + added[1] + " with weight " + ways[added[1]]);
            System.out.println();
        }
        return ways;
    }

    private int[] findMinWays2(int[][] adjMatrix, int key) {
        int[] ways = new int[adjMatrix.length];
        Arrays.fill(ways, -1);
        ways[key] = 0;
        ArrayList<Integer> lastVisited = new ArrayList<>();
        lastVisited.add(key);
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i =0; i<ways.length; i++){

            for (int j : lastVisited) {

                for (int k =0; k<ways.length ; k++){

                    if(adjMatrix[j][k] != -1 && adjMatrix[j][k] < ways[k] ) {
                        temp.add(k);
                        ways[k] = adjMatrix[j][k];
                    }

                }

            }
            System.out.println("Last visited " + lastVisited.toString());
            System.out.println("Temp " + temp.toString());
            lastVisited.clear();
            lastVisited.addAll(temp);
            temp.clear();

        }

        return ways;
    }

    int[] findMinimum(int[][] adjMatrix, int k) {
        boolean[] visited = new boolean[adjMatrix.length];
        visited[k] = true;
        int[] way = new int[adjMatrix.length];
        Arrays.fill(way, -1);
        way[k] = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            int min = Integer.MAX_VALUE, from = -1, to = -1;
            for (int a = 0; a < adjMatrix.length; a++) {
                if (visited[a]) {
                    for (int b = 0; b < adjMatrix.length; b++) {
                        if (!visited[b] && adjMatrix[a][b] != -1 && adjMatrix[a][b] < min) {
                            min = adjMatrix[a][b];
                            from = a;
                            to = b;
                        }
                    }
                }
            }
            if (min != Integer.MAX_VALUE && to != -1) {
                visited[to] = true;
                for(int c=0;i<adjMatrix[to].length; i++){
                    if(adjMatrix[to][c] != -1){
                        adjMatrix[to][c] += adjMatrix[from][to];
                    }
                }
                way[to] = adjMatrix[from][to];
            }
            for (int[] arr : adjMatrix) {
                System.out.println(Arrays.toString(arr));
            }
        }
        return way;
    }

    int[][] rearrangeAdjMatrix(int[][] adjMatrix, int[] accessibleNodes) {
        int[][] newMatrix = new int[accessibleNodes.length][adjMatrix.length];
        int index = 0;
        for (int i : accessibleNodes) {
            newMatrix[index] = adjMatrix[i];
            index++;
        }
        return newMatrix;
    }

}
