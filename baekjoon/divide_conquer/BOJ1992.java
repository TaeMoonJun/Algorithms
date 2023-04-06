import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] vid;
    static StringBuilder sb = new StringBuilder();

    static void recur(int a, int b, int size) {
        for (int i = a; i < a+size; i++) {
            for (int j = b; j < b + size; j++) {
                if (vid[i][j] != vid[a][b]) {
                    sb.append("(");
                    recur(a, b, size/2);
                    recur(a, b+size/2, size/2);
                    recur(a+size/2, b, size/2);
                    recur(a+size/2, b+size/2, size/2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(vid[a][b]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        vid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                vid[i][j] = str.charAt(j);
            }
        }

        recur(0,0, n);
        System.out.println(sb);
    }
}