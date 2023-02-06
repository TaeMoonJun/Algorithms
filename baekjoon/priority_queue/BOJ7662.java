import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 이중 우선순위 큐
public class BOJ7662 {
    static TreeMap<Integer, Integer> map;

    static void insert(int a) {
        if (map.containsKey(a)) {
            map.replace(a, map.get(a) + 1);
        } else {
            map.put(a, 1);
        }
    }

    static void delete(String str) {
        if (map.isEmpty()) {
            return;
        }

        if (str.equals("1")) {
            int a = map.lastEntry().getValue();
            if (a > 1) {
                map.replace(map.lastKey(), a-1);
            } else {
                map.pollLastEntry();
            }
        } else {
            int a = map.firstEntry().getValue();
            if (a > 1) {
                map.replace(map.firstKey(), a-1);
            } else {
                map.pollFirstEntry();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("I")) {
                    insert(Integer.parseInt(st.nextToken()));
                } else {
                    delete(st.nextToken());
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
