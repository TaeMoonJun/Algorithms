import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A → B
public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 1;

        while (a != b) {
            count++;
            if (a > b) {
                count = -1;
                break;
            } else if (b % 10 == 1) {
                b = (b - 1) / 10;
            } else if (b % 2 == 0) {
                b = b / 2;
            } else {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}