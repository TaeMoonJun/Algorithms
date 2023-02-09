import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 신입 사원
public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] fresh = new int[n][2];
            int count = 0, lowest;

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                fresh[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            Arrays.sort(fresh, (o1, o2) ->{
                return o1[0] - o2[0];
            });

            lowest = fresh[0][1];
            for (int j = 0; j < n; j++) {
                if (lowest < fresh[j][1]) {
                    count++;
                } else {
                    lowest = fresh[j][1];
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }
}
// 한번 틀림 문제를 쉽게 만들 방법 생각하기
