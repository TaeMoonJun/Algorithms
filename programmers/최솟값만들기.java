import java.util.*;

//12941
class 최솟값만들기
{
    public int solution(int []A, int []B)
    {
        int answer = 0, length = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<length;i++){
            answer += A[i]*B[length-1-i];
        }

        return answer;
    }
}