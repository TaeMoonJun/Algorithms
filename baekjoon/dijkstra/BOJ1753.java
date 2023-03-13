import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
public class BOJ1753 {
    static int v, e, start, max;
    static Integer[] dist;
    static ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
    static PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
        return o1[1] - o2[1];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine()) -1;
        max = v * 10;
        dist = new Integer[v];

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())-1)
                    .add(new Integer[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
        }

        Arrays.fill(dist, max);
        dist[start] = 0;
        pq.add(new Integer[]{start, 0});

        while (!pq.isEmpty()) {
            Integer[] tmp = pq.poll();

            if (tmp[1] > dist[tmp[0]]) {
                continue;
            }

            for (Integer[] travel : list.get(tmp[0])) {
                if (dist[travel[0]] > dist[tmp[0]] + travel[1]) {
                    dist[travel[0]] = dist[tmp[0]] + travel[1];
                    pq.add(new Integer[]{travel[0], dist[travel[0]]});
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if (dist[i] == max) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}