import java.util.*;

//42627
//Priority Queue
class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0, now= 0, jIdx= 0;
        Arrays.sort(jobs, (o1, o2)->{
            return o1[0]-o2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o1[1]-o2[1];
        });

        while(true){
            for(;jIdx<jobs.length;jIdx++){
                if(jobs[jIdx][0]<=now){ // 대기중인 작업 있었음
                    pq.add(jobs[jIdx]);
                }else if(pq.isEmpty()){ // 대기중인 작업 없었음
                    now = jobs[jIdx][0];
                    pq.add(jobs[jIdx]);
                }else{  // 대기중인 작업은 다 들어감
                    break;
                }
            }
            System.out.println(pq.size());
            if(pq.isEmpty()){
                break;
            }
            int[] job = pq.poll();
            if(now>job[0]){
                answer += now - job[0];
            }
            answer+= job[1];
            now+= job[1];
        }

        return answer/jobs.length;
    }
}
//완전 무시했는데 생각보다 고려할게 있었음
//(pq에 작업 넣을때 if문)