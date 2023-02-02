import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 파도반 수열
public class BOJ9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int max = 0;
        int[] tc = new int[T];
        long[] pado;

        for (int i = 0; i < T; i++) {   // test cases 와 최대값 저장
            tc[i] = Integer.parseInt(br.readLine());
            if (tc[i] > max) {
                max = tc[i];
            }
        }

        pado = new long[max];
        pado[0] = pado[1] = pado[2] = 1;

        for (int i = 3; i < max; i++) {
            pado[i] = pado[i - 3] + pado[i - 2];
        }

        for (int i : tc) {
            sb.append(pado[i-1]).append("\n");
        }

        System.out.println(sb);
    }
}
// 수열의 규칙 pado[i] = pado[i - 3] + pado[i - 2];
// test case 의 max 값까지만 계산
// max=100 일때 값 확인 후 pado long[]으로
