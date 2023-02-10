import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 토마토
public class BOJ7576 {
    static Integer[] xPush = {0, 1, 0, -1};
    static Integer[] yPush = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int tomatoLeft = n * m, yesterday = n * m, day = 0;
        Deque<Integer[]> deque = new LinkedList<>();
        String[][] tomato = new String[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = st.nextToken();
                if(tomato[i][j].equals("1")){
                    deque.add(new Integer[]{i, j});
                    tomatoLeft--;
                } else if (tomato[i][j].equals("-1")) {
                    tomatoLeft--;
                }
            }
        }

        while (tomatoLeft > 0) {
            int added = deque.size();
            for (int a = 0; a < added; a++) {
                Integer[] done = deque.poll();
                for (int i = 0; i < 4; i++) {
                    int yNew = done[0] + yPush[i], xNew = done[1] + xPush[i];
                    if (yNew >= 0 && yNew < m && xNew >= 0 && xNew < n) {
                        if (tomato[yNew][xNew].equals("0")) {
                            tomato[yNew][xNew] = "1";
                            deque.add(new Integer[]{yNew, xNew});
                            tomatoLeft--;
                        }
                    }
                }
            }
            day++;
            if (yesterday == tomatoLeft) {
                day = -1;
                break;
            }
            yesterday = tomatoLeft;
        }

        System.out.println(day);
    }
}
// for 문의 조건을 'a < deque.size()'로 했더니 deque.size의 변화로 잘 못 실행됐음