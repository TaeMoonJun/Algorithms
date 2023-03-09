import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class BOJ1920 {
    static int n, m;
    static int[] arr;

    static int binarySearch(int num) {
        int bottom = 0;
        int top = n-1;

        while (bottom<=top) {
            int idx = (bottom + top) / 2;
            if (arr[idx] > num) {
                top = idx-1;
            } else if (arr[idx] < num) {
                bottom = idx+1;
            } else if (arr[idx] == num) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }
}