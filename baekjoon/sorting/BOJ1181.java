import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 단어 정렬
public class BOJ1181{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, ((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            else {
                return o1.compareTo(o2);
            }
        }));

        sb.append(str[0]).append("\n");
        for (int i = 1; i < str.length; i++) {
            if (!str[i - 1].equals(str[i])) {
                sb.append(str[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
