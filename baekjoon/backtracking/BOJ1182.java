import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분수열의 합
public class BOJ1182 {
    static int n, s, count=0, sum = 0;
    static int[] nums;

    public static void dfs(int num) {
        if (num == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(num + 1);
        sum += nums[num];

        dfs(num + 1);
        sum -= nums[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println((s==0) ? count-1 : count);
    }
}