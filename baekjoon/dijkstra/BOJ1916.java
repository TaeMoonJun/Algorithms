import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소비용 구하기
public class BOJ1916{
    static int n, m, start, end;
    static int[] dist;
    static int[][] graph;
    static boolean[] visited;

    static void dijkstra() {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && min > dist[i]) {
                min = dist[i];
                idx = i;
            }
        }

        for (int i = 0; i < n; i++) {
            dist[i] = (int) Math.min(dist[i], Integer.toUnsignedLong(dist[idx]) + graph[idx][i]);
        }
        visited[idx] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];

        for (int[] i : graph) {
            Arrays.fill(i, 100000000);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            graph[start][end] = Math.min(graph[start][end], Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;
        dist = graph[start].clone();
        dist[start] = 0;
        visited[start] = true;

        for (int i = 1; i < n; i++) {
            dijkstra();
        }

        System.out.println(dist[end]);
    }
}
// 우선순위 큐를 이용한 개선된 다익스트라 알고리즘이 더 효율적.
// graph를 Integer.MAX_VALUE로 초기화할 시 런타임 에러
// -> 문제를 풀때 적절한 max 값 잡기 (최대 거리 * (간선 수 -1))
