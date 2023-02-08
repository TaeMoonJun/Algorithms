import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        int[] xWay = {0, 1, 0, -1};
        int[] yWay = {1, 0, -1, 0};   // a % 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[][] apple = new boolean[n][n];
        int way = 0, time = 0;
        boolean boom = false;
        Deque<Integer[]> snake = new LinkedList<>();
        Deque<Integer[]> change = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            apple[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            change.add(new Integer[] {Integer.parseInt(st.nextToken()), st.nextToken().equals("D") ? 1 : -1});
        }

        snake.addFirst(new Integer[] {0,0});
        while (true) {
            time++;
            Integer[] oldP = snake.peekLast();
            if (way < 0) {
                way += 4;
            }
            Integer[] newP = new Integer[]{oldP[0] + xWay[way%4], oldP[1] + yWay[way%4]};

            if (newP[0] < 0 || newP[1] < 0 || newP[0] >= n || newP[1] >= n) {   // 벽에 박는지
                break;
            }

            for (Integer[] body : snake) {
                if (Arrays.equals(body, newP)) {    // 몸에 닿는지
                    boom = true;
                    break;
                }
            }
            if (boom) {
                break;
            }

            if (!apple[newP[0]][newP[1]]) { // apple 먹는지
                snake.poll();
            } else{
                apple[newP[0]][newP[1]] = false;
            }

            if (!change.isEmpty()) {
                if(time == change.peek()[0]) {  // 방향 바꿔야 하는지
                    way += change.poll()[1];
                }
            }
            snake.add(newP);
        }

        System.out.println(time);
    }
}
// 1차 way가 음수가 되어 ArrayIndexOutOfBounds
// 2차 먹은 사과를 지우는 연산이 없었음
