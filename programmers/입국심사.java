import java.util.Arrays;

//43238
class 입국심사 {
    public long solution(int n, int[] times) {
        long max = (long) n*times[0];
        long min = 0, mid=0, sum, answer=max;

        Arrays.sort(times);

        while(min <= max){
            mid = (max+min)/2;
            sum = 0;

            for(int i: times){
                sum+= mid/i;
            }

            if(sum>=n){
                max = mid-1;
                answer = mid;
            }else{
                min = mid+1;
            }
        }

        return answer;
    }
}