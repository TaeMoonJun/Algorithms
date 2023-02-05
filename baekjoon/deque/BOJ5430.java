import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

// AC
public class BOJ5430 {
    static String AC(int n, String code, StringTokenizer st) {
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        int reverse = 0;

        for (int i = 0; i < n; i++) {
            deque.addFirst(st.nextToken());
        }

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == 'R') {
                reverse++;
            } else if (deque.isEmpty()) {
                return "error\n";
            } else if (reverse % 2 == 1) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }

        Iterator<String> iter = (reverse % 2 == 1) ? deque.iterator() : deque.descendingIterator();

        sb.append("[");
        while (iter.hasNext()) {
            sb.append(iter.next()).append(",");
        }
        if (sb.length() != 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.append("]\n").toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String code = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str.substring(1, str.length()-1), ",");
            sb.append(AC(n, code, st));
        }
        System.out.println(sb);
    }
}
// int reverse가 짝수이면 기본적인 상황,
// 홀수이면 뒤집혀진 상황으로 여김
