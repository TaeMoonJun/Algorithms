import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 숨바꼭질 3
class Node implements Comparable<Node>{
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        if (this.dist == o.dist) {
            return this.idx - o.idx;
        }
        return this.dist - o.dist;
    }
}

public class BOJ13549 {
    static int n, m;
    static PriorityQueue<Node> pq;
    static int[] dist;

    static int dfs() {
        pq.add(new Node(m, 0));
        if (m < n) {
            return n - m;
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.idx == n) {
                return node.dist;
            }

            if (node.idx > n) {
                if (node.idx % 2 == 0 && dist[node.idx/2] > node.dist) {
                    dist[node.idx / 2] = node.dist;
                    pq.add(new Node(node.idx / 2, node.dist));
                }
                if (dist[node.idx-1] > node.dist+1) {
                    dist[node.idx-1] = node.dist+1;
                    pq.add(new Node(node.idx - 1, node.dist + 1));
                }
            }
            if(node.idx+1 < dist.length && dist[node.idx+1] > node.dist+1){
                dist[node.idx+1] = node.dist+1;
                pq.add(new Node(node.idx + 1, node.dist + 1));
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        dist = new int[100001];

        Arrays.fill(dist, 100001);

        System.out.println(dfs());
    }
}
// 그래프 이론으로 분류돼있었는데 일단 우선순위큐로 풂
// 큐나 우선순위큐는 큐 넣는걸 최소화하는게 중요!!
