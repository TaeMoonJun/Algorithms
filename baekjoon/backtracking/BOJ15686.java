import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨 배달
public class BOJ15686{
    static int n, m, ans;
    static ArrayList<Integer[]> house, chicken;

    static void close(int idx, int count) {
        if (count == chicken.size() - m) {
            cal();
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            Integer[] tmp = chicken.get(i);
            chicken.set(i, new Integer[]{-1, -1});
            close(i + 1, count + 1);
            chicken.set(i, tmp);
        }
    }

    static void cal() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int dist = 100;
            Integer[] a = house.get(i);
            for (int j = 0; j < chicken.size(); j++) {
                Integer[] ac = chicken.get(j);
                if (ac[0] == -1) {
                    continue;
                }
                dist = Math.min(dist, Math.abs(a[0] - ac[0]) + Math.abs(a[1] - ac[1]));
            }
            sum += dist;
        }
        ans = Math.min(ans, sum);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 2 * n * 100;
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) {
                    house.add(new Integer[]{i, j});
                } else if (status == 2) {
                    chicken.add(new Integer[]{i, j});
                }
            }
        }

        close(0,0);
        System.out.println(ans);
    }
}
// 집과 치킨집의 위치만 ArrayList에 저장
// dfs로 폐업을 하는 close 메소드에서 폐업한 치킨집 좌표를 -1로
// 거리를 계산하는 cal 메소드에서 pruning하면 속도 더 개선되려나?