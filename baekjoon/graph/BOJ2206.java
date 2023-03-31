import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class BOJ2206 {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n, m;
    static char[][] graph;
    static boolean[][][] visited;

    static int bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0, 0, 1}); //벽뚫여부, x,y, count
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            if (node[1] == n - 1 && node[2] == m - 1) {
                return node[3];
            }

            for (int i = 0; i < 4; i++) {
                int x = node[1] + dx[i];
                int y = node[2] + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }
                if (visited[node[0]][x][y]) {
                    continue;
                }

                if (graph[x][y] == '1') {
                    if (node[0] == 0) {
                        queue.add(new Integer[]{1, x, y, node[3] + 1});
                        visited[1][x][y] = true;
                    }
                } else {
                    queue.add(new Integer[]{node[0], x, y, node[3]+1});
                    visited[node[0]][x][y] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }
        System.out.println(bfs());

    }
}
// vistied = true 를 큐에 넣을때 하지 않고 queue.poll 시에 하니 메모리 초과
