import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 좌표 압축
public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] space = new int[n], spaceSort;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            space[i] = Integer.parseInt(st.nextToken());
        }
        spaceSort = space.clone();
        Arrays.sort(spaceSort);

        for (int i: spaceSort) {
            if (!map.containsKey(i)) {
                map.put(i, count++);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(space[i])).append(" ");
        }
        System.out.println(sb);
    }
}
// 좌표 압축 알고리즘?
