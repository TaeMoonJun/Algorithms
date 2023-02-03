import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int [] weight = new int[n + 1], value = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], value[i-1] + dp[i - 1][j-weight[i-1]]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
// 무조건 다시풀기! 알고리즘 수업 ppt 보고 풀음....
