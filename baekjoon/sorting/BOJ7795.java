import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가
public class BOJ7795{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arrA = new int[n], arrB = new int[m];
            int sum = 0, count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);

            for (int j = 0; j < n; j++) {
                for (int k = count; k < m; k++) {
                    if (arrA[j] <= arrB[k]) {
                        break;
                    } else {
                        count++;
                    }
                }
                sum += count;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}

