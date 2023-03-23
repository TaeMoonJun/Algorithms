import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전깃줄
public class BOJ2565 {
    static int n, ans;
    static int[][] line;
    static int[] dp;

    static int setLine() {
        for (int i = 1; i < n + 1; i++) {
            if (line[i][1] == 0) {
                continue;
            }
            int max = 1;

            for (int j = 1; j < i; j++) {
                if (line[j][1] > line[i][1]) {
                    continue;
                }
                max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        line = new int[n+1][2];
        dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[i] = new int[]{a, b};
        }

        Arrays.sort(line, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        System.out.println(n - setLine());
    }
}
// ㅠㅠ