import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 카드 정렬하기
public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int newCard = pq.poll() + pq.poll();
            sum += newCard;
            pq.add(newCard);
        }
        System.out.println(sum);
    }
}
// 묶음 중에 가장 작은 거 2개씩!!
