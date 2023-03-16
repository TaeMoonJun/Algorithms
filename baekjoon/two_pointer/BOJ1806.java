import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합
public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int start = 0, end = 0, sum = 0, ans = 100001;
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        sum += num[start];

        while (start<=end) {
            if (sum < s) {
                end++;
                if (end < n) {
                    sum += num[end];
                } else {
                    break;
                }
            } else if (sum >= s) {
                ans = Math.min(ans, end - start);
                sum -= num[start];
                start++;
            }
        }
        System.out.println((ans == 100001) ? 0 : ans+1);
    }
}