import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 2
public class BOJ2003{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = 0, end = 0, sum = 0, ans = 0;
        int[] seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        sum += seq[start];
        while (start < n) {
            if (sum == m) {
                ans++;
                if(end + 1 < n) {
                    sum += seq[++end];
                }
                sum -= seq[start++];
            } else if (sum < m) {
                if(end + 1 < n) sum += seq[++end];
                else break;
            } else {
                sum -= seq[start++];
            }
        }
        System.out.println(ans);
    }
}
