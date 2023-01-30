import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 계단 오르기
public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n];
        int oo=0, x=0, ox, temp;

        for (int i = n-1; i >= 0; i--) {
            point[i] = Integer.parseInt(br.readLine());
        }
        ox = point[0];

        if (n > 1) {
            x = ox;
            oo = ox + point[1];
            if (n > 2) {
                ox = x + point[2];
                x = oo;
                oo = 0;
            }
        }

        for (int i = 3; i < n; i++) {
            temp = x;
            x = Integer.max(oo, ox);
            oo = ox + point[i];
            ox = temp + point[i];
        }
        System.out.println(Integer.max(x, Integer.max(oo, ox)));
    }
}
/* 마지막 계단을 반드시 밟아야하므로 거꾸로 계단 내려가기로 보았음
최근의 계단에 대해서 밟은 여부를 X, OO, OX로 나누어서
X -> OO와 OX 중 최댓값
OO -> OX에 다음 계단값 추가
OX -> X에 다음 계단값 추가
초반 단계의 oo=0 이 없어 두 계단을 연속해서 밟지 않는 경우 생겼었음
(계단이 3개일때 oo인 경우는 없음)
이런 방식보다 마지막 계단부터 배열을 만들어 한칸 가거나 두칸 가는 방식이 나은 듯;
*/
