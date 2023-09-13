import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이 만들기
public class BOJ2630 {
    static int n;
    static int[] count = new int[2];
    static int[][] paper;

    public static void recur(int x, int y, int size) {
        if (size == 1) {
            count[paper[x][y]]++;
            return;
        }

        int init = paper[x][y];
        int now = init;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != init) {
                    now = paper[i][j];
                    recur(x, y, size/2);
                    recur(x+size/2, y, size/2);
                    recur(x, y+size/2, size/2);
                    recur(x+size/2, y+size/2, size/2);
                    break;
                }
            }
            if (now != init) {
                break;
            }
        }
        if (now == init) {
            count[init]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }
}