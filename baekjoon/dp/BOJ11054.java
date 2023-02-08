import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열
public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int [n], dp1 = new int[n], dp2 = new int[n];
        int max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp1[j] >= dp1[i] && arr[j] < arr[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (dp2[j] >= dp2[i] && arr[j] < arr[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
            max = Math.max(max, dp1[i] + dp2[i]);
        }

        System.out.println(max-1);
    }
}
// BOJ11053 * 2
