import java.util.*;

//12980
public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while(n>0){
            while(n%2 == 0){
                n=n/2;
            }
            n--;
            ans++;
        }

        return ans;
    }
}