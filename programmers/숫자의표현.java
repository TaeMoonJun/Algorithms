//12924
class 숫자의표현 {
    public int solution(int n) {
        int answer=1;
        if(n==1 || n==2){
            answer--;
        }
        int[] arr = new int[n/2+2];

        for(int i=1;i<n/2+2;i++){
            arr[i] = arr[i-1] + i;
        }

        for(int i=n/2+1;i>0;i--){
            int now = arr[i];
            if(now <n){
                break;
            } else if(now ==n){
                answer++;
                break;
            }
            for(int j=i-1;j>0;j--){
                if(now-arr[j] == n){
                    answer++;
                    break;
                } else if(now-arr[j]>n){
                    break;
                }
            }

        }

        return answer;
    }
}
//나름 효율 신경썼는데 그것 때문에 n이 1이랑 2일때 반례 존재