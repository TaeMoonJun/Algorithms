import java.util.Arrays;

//72413
class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] graph = new int[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], 20000000);
            graph[i][i] = 0;
        }

        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {   // 헤어지는 지점 i
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return answer;
    }
}
//헤어지는 지점에서 목적지 거리합 + 헤어지는 지점까지

//출발지와 두 목적지에 대한 다익스트라여도 됐음
//플로이드워셜 중간지점을 가장 안쪽 for문에 뒀었음...