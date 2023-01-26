import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 덱
public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    sb.append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst());
                    sb.append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.getLast());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
