import java.io.*;

class BOJ1913 {
    static int[][] square;
    static int n, m;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        square = new int[n][n];
        int[] ans = new int[2];

        put(n/2, n/2, n/2, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(square[i][j]).append(" ");
                if (square[i][j] == m) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ans[0]).append(" ").append(ans[1]);
        System.out.println(sb);
    }

    static void put(int y, int x, int depth, int num) {
        if (depth == -1) {
            return;
        }

        int fin = square.length - depth -1;

        square[y][x] = num;
        for (int i = x+1; i <= fin; i++) {   // 위쪽
            square[y][i] = ++num;
            x = i;
        }

        for (int i = y+1; i <= fin; i++) {   // 우측
            square[i][x] = ++num;
            y = i;
        }

        for (int i = x-1; i >= depth; i--) { //아래
            square[y][i] = ++num;
            x = i;
        }

        for (int i = y-1; i >= depth; i--) { //좌측
            square[i][x] = ++num;
            y = i;
        }

        put(y-1,x,depth-1, num+1);
    }
}