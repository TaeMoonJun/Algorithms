import java.util.*;

//12939
class 최댓값과최솟값 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[st.countTokens()];

        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        return arr[0] +" "+arr[arr.length-1];
    }
}
//그저 sort