import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");

        while (st2.hasMoreTokens()) {
            sum += Integer.parseInt(st2.nextToken());   // "-" 나오기 전까지
        }
        while (st1.hasMoreTokens()) {
            st2 = new StringTokenizer(st1.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                sum -= Integer.parseInt(st2.nextToken());   // "-" 나오고나면
            }
        }
        System.out.println(sum);
    }
}
