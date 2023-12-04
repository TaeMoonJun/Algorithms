import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//49189
class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]-1).add(e[1]-1);
            graph.get(e[1]-1).add(e[0]-1);
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            ArrayList<Integer> list = graph.get(i);
            for (int target : list) {
                if (!visited[target]) {
                    visited[target] = true;
                    dist[target] = dist[i]+1;
                    queue.add(target);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (max < dist[i]) {
                max = dist[i];
                answer = 1;
            } else if (max == dist[i]) {
                answer++;
            }
        }

        return answer;
    }
}