import java.util.ArrayList;

class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix1 = new int[rows+1][columns+1];
        int[][] matrix2 = new int[rows+1][columns+1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix1[i][j] = (i - 1) * columns + j;
            }
        }

        for (int[] query : queries) {
            int min = rows*columns;
            int x = query[0];
            int y = query[1];

            for (int i = 0; i <= rows; i++) {
                matrix2[i] = matrix1[i].clone();
            }

            for (y++; y <= query[3]; y++) {
                matrix2[x][y] = matrix1[x][y-1];
                min = Math.min(min, matrix2[x][y]);
            }
            for (x++,y--; x <= query[2]; x++) {
                matrix2[x][y] = matrix1[x-1][y];
                min = Math.min(min, matrix2[x][y]);
            }
            for (y--, x--; y >= query[1]; y--) {
                matrix2[x][y] = matrix1[x][y+1];
                min = Math.min(min, matrix2[x][y]);
            }
            for (x--, y++; x >= query[0]; x--) {
                matrix2[x][y] = matrix1[x+1][y];
                min = Math.min(min, matrix2[x][y]);
            }

            list.add(min);
            for (int i = 0; i <= rows; i++) {
                matrix1[i] = matrix2[i].clone();
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

//풀다가 멍청했던 부분
//1. 2차원 배열 깊은 복사는 for문으로 돌면서 해야함
//2. 행렬 x,y 문제 잘보기...
//3. for문에서 x, y를 쓸때 for문 외부 지역변수라서 처리해줬어야함

//다른 사람들은 queue 쓰는 경우도 있고
// dx,dy 같은걸로 현재 위치에 따라 한칸씩 이동시키는 경우도