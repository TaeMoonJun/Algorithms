import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표 정렬하기
public class BOJ11650{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(xy, (o1, o2) -> {
            return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            sb.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
