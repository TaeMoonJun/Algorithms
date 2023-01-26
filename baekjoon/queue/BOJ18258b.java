import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int lastAdd = -1;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push":
                    lastAdd = Integer.parseInt(st.nextToken());
                    queue.add(lastAdd);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek());
                    sb.append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : lastAdd);
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
// Queue 클래스 사용
// sout 사용시 시간초과 -> StringBuilder 사용
