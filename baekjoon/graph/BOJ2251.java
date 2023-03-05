import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 물통
public class BOJ2251 {
    static int[] bottle;
    static boolean[][] visited;
    static ArrayList<Integer> ans;

    static void move(int[] status) {
        if (status[0] == 0) {
            ans.add(status[2]);
        }
        visited[status[0]][status[1]] = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] status2 = status.clone();
                if (i != j && status2[j] != 0) {
                    int water = Math.min(status2[j], bottle[i] - status2[i]);
                    status2[i] += water;
                    status2[j] -= water;
                }
                if (!visited[status2[0]][status2[1]]) {
                    move(status2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        bottle = new int[3];
        ArrayList<Integer> ans = new ArrayList<>()

        for (int i = 0; i < 3; i++) {
            bottle[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[bottle[0]+1][bottle[1]+1];

        move(new int[]{0,0,bottle[2]});

        ans.sort(Comparator.naturalOrder());
        sb.append(ans.get(0)).append(" ");
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i - 1) != ans.get(i)) {
                sb.append(ans.get(i)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
// 물통 부피가 <= 200 이라 방문한 상태를 Integer[]로 저장해 탐색하는 대신에
// A 물통과 B 물통의 물 양을 인덱스로 boolean[][] visited 에 접근
