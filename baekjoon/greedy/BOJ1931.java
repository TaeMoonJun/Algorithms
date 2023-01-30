import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정
public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0, time = 0;
        int[][] meet = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meet, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });

        for (int i = 0; i < n; i++) {
            if (meet[i][0] >= time) {
                time = meet[i][1];
                count ++;
            }
        }
        System.out.println(count);
    }
}
// 종료시간(같을 경우 시작시간)만 고려하면 풀린다?
