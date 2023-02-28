import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 토마토
class Node {
    int h;
    int n;
    int m;

    public Node(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }
}

// 토마토
public class BOJ7569{
    static int n, m, h, day = 0, tomatoYet = 0;
    static String[][][] tomato;
    static LinkedList<Node> nodeList;

    static int[] dx = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dy = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, -1, 1};

    static void flow(Node node) {
        for (int i = 0; i < 6; i++) {
            int xx = node.n + dx[i];
            int yy = node.m + dy[i];
            int zz = node.h + dz[i];
            if (xx >= 0 && yy >= 0 && zz >= 0 && xx < n && yy < m && zz < h) {
                if (tomato[zz][xx][yy].equals("0")) {
                    tomato[zz][xx][yy] = "1";
                    nodeList.add(new Node(zz, xx, yy));
                    tomatoYet--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new String[h][n][m];
        nodeList = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = st.nextToken();
                    if (tomato[i][j][k].equals("1")) {
                        nodeList.add(new Node(i, j, k));
                    } else if (tomato[i][j][k].equals("0")) {
                        tomatoYet++;
                    }
                }
            }
        }

        while (tomatoYet != 0) {
            int num = nodeList.size();
            day++;

            for (int i = 0; i < num; i++) {
                flow(nodeList.poll());
            }

            if (nodeList.isEmpty()) {
                break;
            }
        }

        System.out.println((tomatoYet == 0) ? day : -1);
    }
}
