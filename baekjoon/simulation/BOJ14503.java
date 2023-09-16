import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//로봇 청소기
public class BOJ14503 {
    static int[] dn = {-1, 0, 1, 0};
    static int[] dm = {0, 1, 0, -1};
    static int n, m, r, c, way, count = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        way = Integer.parseInt(st.nextToken()); // 북 동 남 서
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 청소
            if (map[r][c] == 0) {
                count++;
                map[r][c] = 2;
            }

            // 청소 안된 칸 확인 및 회전
            boolean notClean = false;
            int cway = way;
            for (int i = 0; i < 4; i++) {
                cway = (cway + 3) % 4;
                int cr = r + dn[cway];
                int cc = c + dm[cway];
                if (cr >= 0 && cr < n && cc >= 0 && cc < m) {
                    if (map[cr][cc] == 0) {
                        notClean = true;
                        way = cway;
                        r = cr;
                        c = cc;
                        break;
                    }
                }
            }

            // 후진 또는 종료
            if (!notClean) {
                int cr = r - dn[way];
                int cc = c - dm[way];
                if (cr >= 0 && cr < n && cc >= 0 && cc < m) {
                    if (map[cr][cc] != 1) {
                        r = cr;
                        c = cc;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}