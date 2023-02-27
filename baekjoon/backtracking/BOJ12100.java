import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2048 (Easy)
public class BOJ12100{
    static int n, ans = 0, num = 5;
    static int[] dx = new int[]{-1, 1};
    static int[][] graph;
    static boolean change;
    static boolean[][] hap;

    static void dfs(int count) {
        if (count == num) {
            cal();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] tmp = cloneArray(graph);
            move(i);

            if (change) {
                dfs(count + 1);
            } else {
                cal();
            }
            graph = cloneArray(tmp);
        }
    }

    static int[][] cloneArray(int[][] array) {
        int[][] array2 = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i].clone();
        }
        return array2;
    }

    static void move(int way) {
        change = false;
        hap = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x, y, xx, yy, initial;
                if (way % 2 == 0) {
                    xx = (way <= 1) ? i : n -1 - i;
                    yy = (way <= 1) ? j : n -1 - j;
                    x = xx + dx[way / 2];
                    y = yy;
                } else {
                    xx = (way <= 1) ? j : n -1 - j;
                    yy = (way <= 1) ? i : n -1 - i;
                    x = xx;
                    y = yy + dx[way / 2];
                }
                initial = graph[xx][yy];

                if (initial == 0) {
                    continue;
                }

                while (x >= 0 && y >= 0 && x < n && y < n) {
                    if (graph[x][y] == 0) {
                        graph[x][y] = initial;
                        graph[xx][yy] = 0;
                        change = true;
                    } else if (graph[x][y] == initial && !hap[x][y]) {
                        graph[x][y] = initial * 2;
                        graph[xx][yy] = 0;
                        change = true;
                        hap[x][y] = true;
                        break;
                    } else {
                        break;
                    }
                    xx = x;
                    yy = y;
                    x = (way % 2 == 0) ? x + dx[way / 2] : x;
                    y = (way % 2 == 0) ? y : y + dx[way / 2];
                }
            }
        }
    }

    static void cal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, graph[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(ans);
    }
}
// 상하좌우 이동을 하나씩 정해서 (way/2), (way%2) 등으로 상황을 나눴는데 너무 복잡하게 짠 것 같음
// 나중에 다시!
