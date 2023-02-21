import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 연구소
public class BOJ14502{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];
        LinkedList<Integer[]> virus = new LinkedList<>();
        int minV = 100, numV = 0, numW = 3;
        int[] pushX = new int[]{0, 1, 0, -1};
        int[] pushY = new int[]{1, 0, -1, 0};


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int status = Integer.parseInt(st.nextToken());
                lab[i][j] = status;
                if (status == 1) {
                    numW++;
                } else if (status == 2) {
                    numV++;
                    virus.add(new Integer[]{i, j});
                }
            }
        }

        for (int i = 0; i < n * m - 2; i++) {
            if (lab[i / m][i % m] != 0) {
                continue;
            }
            for (int j = i + 1; j < n * m - 1; j++) {
                if (lab[j / m][j % m] != 0) {
                    continue;
                }
                for (int k = j + 1; k < n * m; k++) {
                    if (lab[k / m][k % m] != 0) {
                        continue;
                    }

                    LinkedList<Integer[]> nowVirus = new LinkedList<>(virus);
                    int nowV = numV;
                    int[][] wallLab = new int[n][m];
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < m; b++) {
                            wallLab[a][b] = lab[a][b];
                        }
                    }
                    wallLab[i / m][i % m] = wallLab[j / m][j % m] = wallLab[k / m][k % m] = 1;

                    while (!nowVirus.isEmpty()) {
                        Integer[] infect = nowVirus.poll();
                        for (int xy = 0; xy < 4; xy++) {
                            int newX = infect[0] - pushX[xy];
                            int newY = infect[1] - pushY[xy];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                                if (wallLab[newX][newY] == 0) {
                                    nowVirus.add(new Integer[]{newX, newY});
                                    wallLab[newX][newY] = 2;
                                    nowV++;
                                }
                            }
                        }
                    }
                    minV = Math.min(minV, nowV);
                }
            }
        }
        System.out.println(n * m - minV - numW);
    }
}
// 안전공간 = n * m - ((최소 바이러스) - (벽 개수))
// n, m 의 값이 작아 3개의 벽을 브루트포스식으로 놓고 전부 탐색
// 처음에 2차원 배열과 LinkedList 얗은 복사했었음
// 벽을 세우는 부분과 탐색 부분을 메소드로 나누어 풀 필요성
