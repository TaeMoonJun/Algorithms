import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class BOJ11724 {
    static int n, m;
    static boolean[][] graph;
    static boolean[] visited;

    static void dfs(int a) {
        visited[a] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[a][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new boolean[n][n];
        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = graph[b][a] = true;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
            count++;
        }
        System.out.println(count);
    }
}
// 최선인듯 아닌듯...
