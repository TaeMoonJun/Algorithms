import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 알파벳
public class BOJ1987 {
    static int[] nr = new int[]{0, 1, 0, -1};
    static int[] nc = new int[]{1, 0, -1, 0};
    static int r, c, cnt=1, max = 1;
    static Set<Character> set;
    static String[] board;

    static void move(int a, int b) {
        max = Math.max(max, cnt);
        for (int i = 0; i < 4; i++) {
            int aa = a + nr[i];
            int bb = b + nc[i];
            if (aa < 0 || bb < 0 || aa >= r || bb >= c) {
                continue;
            }
            if (!set.contains(board[aa].charAt(bb))) {
                set.add(board[aa].charAt(bb));
                cnt++;

                move(aa, bb);

                cnt--;
                set.remove(board[aa].charAt(bb));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new String[r];
        set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine();
        }

        set.add(board[0].charAt(0));
        move(0, 0);

        System.out.println(max);
    }
}