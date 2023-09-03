import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 4
public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        int[] accum = new int[n+1];
        int[][] gugan = new int[m][2];
        accum[0] = 0;
        num[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            accum[i] = accum[i-1] + num[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            gugan[i][0] = Integer.parseInt(st.nextToken()) - 1;
            gugan[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            sb.append(accum[gugan[i][1]] - accum[gugan[i][0]]).append("\n");
        }
        System.out.println(sb);
    }
}