import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//포도주 시식
public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];
        if (n > 1) {
            dp[2] = wine[1] + wine[2];
        }
        for (int i = 3; i < n+1; i++) {
            dp[i] = Integer.max(dp[i - 1], Integer.max(dp[i - 2] + wine[i], dp[i-3] + wine[i-1]+wine[i]));
        }
        System.out.println(dp[n]);
    }
}
//다시 풀기...