import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테트로미노
public class BOJ14500 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, max=0;
    static int[][] square;
    static boolean[][] visited;

    static void dfs(int x, int y, int sum, int idx) {
        if (idx == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                visited[nx][ny]= true;
                if (idx == 2) {
                    dfs(x, y, sum+square[nx][ny], idx + 1);
                }
                dfs(nx, ny, sum+square[nx][ny], idx + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        square = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i,j, square[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }
}
// ㅗ 모양 블럭을 나중에 확인함
// idx==2 일때 이전 블럭에서 dfs 진행
