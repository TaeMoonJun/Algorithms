import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 줄 세우기
public class BOJ2252 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int n) {
        if (visited[n]) {
            return;
        }
        visited[n] = true;

        for (Integer i : list.get(n)) {
            dfs(i);
        }
        sb.append(n).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        list = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            list.get(small).add(big);
        }

        for (int i = 1; i < n+1; i++) {
            dfs(i);
        }
        System.out.println(sb);
    }
}