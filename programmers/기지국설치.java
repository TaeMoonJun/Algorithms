//12979
class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, now=1, next=n;

        for(int i=0;i<stations.length;i++){
            next = stations[i]-w;
            if(next > now){
                answer+= (next-now)/(w*2+1);
                if((next-now)%(w*2+1) !=0){
                    answer++;
                }
            }
            now = stations[i]+w+1;
        }
        if(n >= now){
            answer += (n+1-now)/(w*2+1);
            if((n+1-now)%(w*2+1) !=0){
                answer++;
            }
        }

        return answer;
    }
}