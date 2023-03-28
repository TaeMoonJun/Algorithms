import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int sum = 0, max = -100 * k;
        int[] temper = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            sum += temper[i];
        }
        max = Math.max(sum, max);
        for (int i = 0; i+k < n; i++) {
            sum -= temper[i];
            sum += temper[i + k];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}