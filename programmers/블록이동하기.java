import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//60063
class 블록이동하기 {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static int[][] rotate1 = new int[][]{{-1, 0}, {-1, 0}};
    static int[][] rotate2 = new int[][]{{1, 1}, {-1, -1}};

    public int solution(int[][] board) {
        int answer = 0;
        int[][][] visitedCost = new int[2][board.length][board.length];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < board.length; j++) {
                Arrays.fill(visitedCost[i][j], 100000);
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{1, 0, 0, 0}); // x, y, way, cost
        visitedCost[0][0][1] = 0;


        while (!queue.isEmpty()) {
            Integer[] state = queue.poll();
//            System.out.println(state[0] + " "+ state[1]);

            if (state[0] == board.length - 1 && state[1] == board.length - 1) {
//                for (int i = 0; i < board.length; i++) {
//                    for (int j = 0; j < board.length; j++) {
//                        System.out.print(Math.min(visitedCost[0][i][j], visitedCost[1][i][j]) + " ");
//                    }
//                    System.out.println();
//                }
                return state[3];
            }

            for (int i = 0; i < 4; i++) {
                int nx = state[0] + dx[i];
                int ny = state[1] + dy[i];
                int tx = nx, ty = ny;

                if (state[2] == 0) {
                    tx--;
                } else {
                    ty--;
                }

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length &&
                        tx >= 0 && tx < board.length && ty >=0 && ty < board.length &&
                        board[ny][nx] == 0 && board[ty][tx] == 0) {
                    if (visitedCost[state[2]][ny][nx] > state[3] + 1) {
                        visitedCost[state[2]][ny][nx] = state[3] + 1;
                        queue.add(new Integer[]{nx, ny, state[2], state[3] + 1});
//                        System.out.println("added1  " + nx +" "+ny);
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                int rx1, ry1, rx2, ry2;

                if (state[2] == 0) {
                    rx1 = state[0] + rotate1[i][0];
                    ry1 = state[1] + rotate2[i][0];
                    rx2 = state[0] + rotate1[i][1];
                    ry2 = state[1] + rotate2[i][1];
                } else {
                    rx1 = state[0] + rotate2[i][0];
                    ry1 = state[1] + rotate1[i][0];
                    rx2 = state[0] + rotate2[i][1];
                    ry2 = state[1] + rotate1[i][1];
                }

                if (rx1 >= 0 && rx1 < board.length && ry1 >= 0 && ry1 < board.length &&
                        rx2 >= 0 && rx2 < board.length  && ry2 >=0 && ry2 < board.length &&
                        board[ry1][rx1] == 0 && board[ry2][rx2] == 0) {
                    if (i == 1) {
                        if (state[2] == 0) {
                            ry1 = state[1];
                            ry2 = state[1];
                        } else {
                            rx1 = state[0];
                            rx2 = state[0];
                        }
                    }
                    if (visitedCost[(state[2]+1)%2][ry1][rx1] > state[3] + 1) {
                        visitedCost[(state[2]+1)%2][ry1][rx1] = state[3] + 1;
                        queue.add(new Integer[]{rx1, ry1, (state[2]+1)%2, state[3] + 1});
//                        System.out.println("added2  " + rx1 +" "+ry1);
                    }
                    if (visitedCost[(state[2]+1)%2][ry2][rx2] > state[3] + 1) {
                        visitedCost[(state[2]+1)%2][ry2][rx2] = state[3] + 1;
                        queue.add(new Integer[]{rx2, ry2, (state[2]+1)%2, state[3] + 1});
//                        System.out.println("added3  " + rx2 +" "+ry2);
                    }
                }
            }
        }

        return answer;
    }
}
//bfs!
//상태
//1. 더 오른쪽이거나 더 아래쪽의 좌표
//2. 방향
//3. cost
//
//int[2][n][n] 배열에 cost 계산

// 아니 회전이 왜 이렇게 어려울까? 설마 멍청해서??
// static을 써서 뭔가 경우를 압축해서 하려고 했으나
//  그냥 [가로/세로] - [회전 방향] - [세부 회전 방향]
// 이렇게 나눠서 회전 방향 가능한지 확인만 해줬다면
// 거기에 좌표를 하나 쓰지말고 두개를 사용했으면 더 편하긴 했을듯