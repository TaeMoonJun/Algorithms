import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num;
        PriorityQueue<Integer> pQue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pQue.isEmpty()) {
                    sb.append("0\n");
                    continue;
                }
                sb.append(pQue.poll()).append("\n");
            } else {
                pQue.add(num);
            }
        }
        System.out.println(sb);
    }
}
