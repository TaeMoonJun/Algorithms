import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치 수 2
public class BOJ2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[Integer.max(n+1,2)];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < n+1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[n]);
    }
}
