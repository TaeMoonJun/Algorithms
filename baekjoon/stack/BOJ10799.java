import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 쇠막대기
public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int open = 0, ans = 0;
        String string = br.readLine();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                open++;
            } else {
                if (open >= 2 && string.charAt(i - 1) == '(') {    // stick 있는 레이저
                    ans += open - 1;
                } else if (string.charAt(i - 1) == ')') {    // stick 종료
                    ans++;
                }
                open--;
            }
        }
        System.out.println(ans);
    }
}
// stack을 안 사용하고 풀음....
// 닫히지 않은 '('의 개수를 open
// open-1을 stick
// laser와 stick의 종료시에 값을 추가
