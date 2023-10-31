import java.util.Arrays;

//12987
class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0, ap=0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<B.length;i++){
            if(A[ap] < B[i]){
                answer++;
                ap++;
            }
        }

        return answer;
    }
}