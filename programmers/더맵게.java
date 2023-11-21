import java.util.PriorityQueue;

//42626
//Priority Queue
class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }

        while(true){
            int least = pq.poll();
            if(pq.isEmpty() && least<K){ // least<K를 안해서 틀렸었음
                answer=-1;
                break;
            }else if(least < K){
                int least2 = pq.poll();
                int food = least + least2*2;
                pq.add(food);
                answer++;
            } else{
                break;
            }
        }

        return answer;
    }
}

//테스트케이스 잘 생각하는 습관을 들이자