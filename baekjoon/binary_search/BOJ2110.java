import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
public class BOJ2110 {
    static int n, c, max=0;
    static int[] house, dist;

    static void binarySearch() {
        int left = 1;
        int right = (house[n-1] - house[0])/(c - 1);

        while (left<=right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;

            for (int i : dist) {
                sum += i;
                if (sum >= mid) {
                    sum = 0;
                    count++;
                }
            }
            if (count >= c - 1) {
                max = Math.max(max, mid);
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        house = new int[n];
        dist = new int[n - 1];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        for (int i = 0; i < n - 1; i++) {
            dist[i] = house[i+1] - house[i];
        }

        binarySearch();
        System.out.println(max);
    }
}