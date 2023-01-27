import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 최대 힙
public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if(pQue.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(pQue.poll()+"\n");
            }
            else
                pQue.add(num);
        }
        System.out.println(sb);
    }
}
// 추가적인 정렬기준 필요할 때는 Comparator 람다식으로 사용해야 함
