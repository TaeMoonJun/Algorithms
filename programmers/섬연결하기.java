import java.util.Arrays;
import java.util.PriorityQueue;

//42861
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int[] m : map) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            map[a][b] = c[2];
            map[b][a] = c[2];
        }

        pq.add(new Integer[]{0, 0});
        while (!pq.isEmpty()) {
            Integer[] visit = pq.poll();
            if(visited[visit[0]]){
                continue;
            }
            visited[visit[0]] = true;
            answer += visit[1];

            for (int j = 0; j < n; j++) {
                if (!visited[j] && map[visit[0]][j] < Integer.MAX_VALUE) {
                    pq.add(new Integer[]{j, map[visit[0]][j]});
                }
            }
        }

        return answer;
    }
}
//다익스트라를 약간 변형해서 푼줄 알았는데 알고보니 이게 프림 알고리즘