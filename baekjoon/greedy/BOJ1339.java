import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 단어 수학
public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxIdx = 0, ans = 0;
        int[] count = new int[10];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                Character ch = word.charAt(j);
                int idx;

                if (!map.containsKey(ch)) {
                    idx = maxIdx++;
                    map.put(ch, idx);
                } else {
                    idx = map.get(ch);
                }
                count[idx] += (int) Math.pow(10, word.length() -j -1);
            }
        }

        Arrays.sort(count);

        for (int i = 9; i >= 10-maxIdx; i--) {
            ans += count[i] * i;
        }
        System.out.println(ans);
    }
}
// Map으로 들어온 최대 10개의 알파벳과 count 배열의 인덱스를 연결했음
// 그냥 배열의 인덱스를 알파벳 연산으로 사용하고 값이 0인 배열 무시하면 더 효율적