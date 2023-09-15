import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//통계학
public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, count = 0, countNow = 0, numNow = -1;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (numNow == arr[i]) {
                countNow++;
            } else {
                countNow = 1;
                numNow = arr[i];
            }

            if (countNow > count) {
                count = countNow;
                list = new ArrayList<>();
                list.add(numNow);
            } else if (countNow == count) {
                list.add(numNow);
            }
        }

        System.out.println(Math.round((float)sum/n));
        System.out.println(arr[(n-1)/2]);
        System.out.println(list.get(list.size() > 1 ? 1 : 0));
        System.out.println(arr[n-1]-arr[0]);
    }
}
// 500,000인데 sort(nlogn) 돌아가넹