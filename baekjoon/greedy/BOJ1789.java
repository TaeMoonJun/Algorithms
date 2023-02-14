import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 수들의 합
public class BOJ1789{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        Long sum = 0L;
        int count = 0;

        for (; sum < n; count++) {
            sum += count;
        }
        System.out.println((sum == n) ? count - 1 : count - 2);
    }
}

