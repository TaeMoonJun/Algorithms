import java.util.Arrays;
import java.util.PriorityQueue;

//67259
class 경주로건설 {
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public int solution(int[][] board) {
        int answer = 1000000000;
        int[][][] visited = new int[4][board.length][board.length];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < board.length; j++) {
                Arrays.fill(visited[i][j], 1000000000);
            }
        }
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new State(0, 0, 1, 0));
        pq.add(new State(0, 0, 3, 0));
        visited[3][0][0] = 0;
        visited[1][0][0] = 0;
        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (state.cost + 100 > answer) {
                break;
            }
//            System.out.printf("%d %d %d %d\n",state.x,state.y,state.way,state.cost);
            for (int i = 0; i < 4; i++) {
                if ((state.way != i) && (state.way < 2 == i < 2)) {
                    continue;
                }
                int nx = state.x + dx[i];
                int ny = state.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                    if (board[nx][ny] == 0) {
                        int nCost = state.way == i ? state.cost + 100 : state.cost + 600;
                        if (visited[i][nx][ny] > nCost) {
                            if (nx == board.length - 1 && ny == board.length - 1) {
                                answer = Math.min(answer, nCost);
                            }
                            pq.add(new State(nx, ny, i, nCost));
                            visited[i][nx][ny] = nCost;
                        }
                    }
                }
            }
        }

        return answer;
    }
}

class State {
    int x;
    int y;
    int way;
    int cost;

    public State(int x, int y, int way, int cost) {
        this.x = x;
        this.y = y;
        this.way = way;
        this.cost = cost;
    }
}
//x,y로 적어놓고 2차원 배열은 방향을 거꾸로 생각하니까 헷갈려...
//스타일을 정해야할듯