import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

//수 묶기
public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            int i = it.next();
            if (!it.hasNext()) {
                sum += i;
                list.remove(0);
                break;
            }
            if (i < 0) {
                int next = list.get(1);
                if (next <= 0) {
                    sum += i * next;
                    it.remove();
                    it.next();
                    it.remove();
                } else {
                    sum += i;
                    list.remove(0);
                    break;
                }
            } else {
                break;
            }
        }
        for (Iterator<Integer> it = list.descendingIterator(); it.hasNext(); ) {
            int i = it.next();
            if (!it.hasNext()) {
                sum += i;
                break;
            }
            if (i > 0) {
                int next = list.get(list.size()-2);
                if (i == 1 || next == 1) {
                    sum += i + next;
                    it.remove();
                    it.next();
                    it.remove();
                } else if (next > 1) {
                    sum += i * next;
                    it.remove();
                    it.next();
                    it.remove();
                }
            }
        }

        System.out.println(sum);
    }
}
//양수, 음수, 특히 0과 1 관련해서 if문을 잘 써야하는데 너무 더러운듯..