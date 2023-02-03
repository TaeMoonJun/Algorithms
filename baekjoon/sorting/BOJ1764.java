import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 듣보잡
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                ans.add(str);
            }
        }

        ans.sort(Comparator.naturalOrder());

        for (String i : ans) {
            sb.append(i).append("\n");
        }
        System.out.println(ans.size());
        System.out.println(sb);
    }
}
// set? sorting?
