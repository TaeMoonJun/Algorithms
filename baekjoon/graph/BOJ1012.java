import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 유기농 배추
public class BOJ1012 {
    static int M, N, K;
    static boolean[][] visited;
    static int[][] cabbage;
    static int[] xPush = {0, -1, 0, 1};
    static int[] yPush = {1, 0, -1, 0};

    public static void traversal(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + xPush[i];
            int yy = y + yPush[i];

            if (xx >= 0 && yy >= 0 && xx < M && yy < N) {
                if (cabbage[xx][yy] == 1 && !visited[xx][yy]) {
                    traversal(xx, yy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);
            visited = new boolean[M][N];
            cabbage = new int[M][N];
            int count = 0;

            for (int j = 0; j < K; j++) {
                str = br.readLine().split(" ");
                cabbage[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        traversal(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
// 상하좌우 탐색 배열 두개로 사용
// 조건문 떡칠은 어쩔 수 없나??
// 따지자면 dfs
