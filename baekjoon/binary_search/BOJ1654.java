import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜선 자르기
public class BOJ1654 {
    static int n, k, max=0;
    static int[] lan;

    static void cutLan() {
        long left = 1;
        long right = max;
        long mid = 0;

        while (left <= right) {
            long lanSum = 0;
            mid = (left+right)/2;

            for (int i = 0; i < n; i++) {
                lanSum += lan[i]/mid;
            }

            if (lanSum >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        lan = new int[n];

        for (int i = 0; i < n; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(lan[i], max);
        }
        cutLan();
    }
}
// right의 최댓값 -> 2^31 -1
// left          -> 1부터 시작
// (left + right)/2 -> (left + right) 에서 int가 터져서... 계속 틀렸음
