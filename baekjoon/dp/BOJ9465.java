import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];
            int[][] dp = new int[n][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sticker[j][0] = Integer.parseInt(st.nextToken());
                sticker[j][1] = Integer.parseInt(st2.nextToken());
            }

            dp[0] = new int[]{sticker[0][0], sticker[0][1], 0};
            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.max(dp[j - 1][1], dp[j - 1][2]) + sticker[j][0];
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + sticker[j][1];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]);
            }
            sb.append(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]))).append("\n");
        }
        System.out.println(sb);
    }
}
// n칸에서 위, 아래와 아무것도 선택하지 않는 경우. [3]으로 풀었음
// [2]로 [0][0] -> [1][1], [2][1]로 푸는게 더 최적화