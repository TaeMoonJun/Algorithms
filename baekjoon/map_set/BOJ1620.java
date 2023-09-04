import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> IntMap = new HashMap<>();
        HashMap<String, Integer> StrMap = new HashMap<>();

        for (int i = 1; i < n+1; i++) {
            String input = br.readLine();
            IntMap.put(i, input);
            StrMap.put(input, i);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            try {
                int key = Integer.parseInt(input);
                sb.append(IntMap.get(key)).append("\n");
            } catch (Exception e) {
                sb.append(StrMap.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}