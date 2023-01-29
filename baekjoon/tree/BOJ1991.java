import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회
public class BOJ1991 {
    static int[][] child;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        child = new int[n][2];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = st.nextToken().charAt(0)-'A';
            child[num][0] = st.nextToken().charAt(0)-'A';
            child[num][1] = st.nextToken().charAt(0)-'A';
        }

        pre(0);
        sb.append("\n");
        in(0);
        sb.append("\n");
        post(0);
        System.out.println(sb);
    }
    public static void pre(int node) {
        sb.append((char)(node+'A'));
        if (child[node][0] > 0) {
            pre(child[node][0]);
        }
        if (child[node][1] > 0) {
            pre(child[node][1]);
        }
    }

    public static void in(int node) {
        if (child[node][0] > 0) {
            in(child[node][0]);
        }
        sb.append((char) (node + 'A'));
        if (child[node][1] > 0) {
            in(child[node][1]);
        }
    }

    public static void post(int node) {
        if (child[node][0] > 0) {
            post(child[node][0]);
        }
        if (child[node][1] > 0) {
            post(child[node][1]);
        }
        sb.append((char) (node + 'A'));
    }
}
// 좀 주먹구구식인가...?
