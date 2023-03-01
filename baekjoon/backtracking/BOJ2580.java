import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 스도쿠
public class BOJ2580{
    static int n = 9;
    static int[][] sudoku = new int[n][n];
    static ArrayList<Integer[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean answer = false;

    static void dfs(int idx) {
        if (answer) {
            return;
        }
        if (idx == list.size()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            answer = true;
            return;
        }
        Integer[] next = list.get(idx);
        for (Integer i : candidate(next[0], next[1])) {
            sudoku[next[0]][next[1]] = i;
            dfs(idx+1);
            sudoku[next[0]][next[1]] = 0;
        }
    }

    static Set<Integer> candidate(int x, int y) {
        List<Integer> tmp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> set1 = new HashSet<>(tmp);
        Set<Integer> set2 = new HashSet<>(tmp);
        Set<Integer> set3 = new HashSet<>(tmp);

        for (int i = 0; i < n; i++) {
            set1.remove(sudoku[x][i]);
            set2.remove(sudoku[i][y]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set3.remove(sudoku[(x / 3)*3 + i][(y / 3)*3 + j]);
            }
        }
        set2.retainAll(set3);
        set1.retainAll(set2);
        return set1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    list.add(new Integer[]{i, j});
                }
            }
        }

        dfs(0);
    }
}
// 시간이 엄청 오래 걸림 -> set, retainAll 사용해서? -> 다음에는 set 없이
// set3.remove(sudoku[(x / 3)*3 + i][(y / 3)*3 + j]);
// 이부분 인덱스를 너무 어렵게 생각함...
