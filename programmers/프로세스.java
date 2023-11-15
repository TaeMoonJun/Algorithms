import java.util.*;

//42587
class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<Integer[]> queue = new LinkedList<>();
        int max=0, count=1;

        for(int i=0;i<priorities.length;i++){
            max = Integer.max(max, priorities[i]);
            queue.add(new Integer[]{i, priorities[i]});
        }

        while(true){
            Integer[] poll = queue.poll();
            if(poll[1] < max){
                queue.add(poll);
            } else{
                if(poll[0]==location){
                    return count;
                }

                max = 0;
                for(Integer[] i: queue){
                    max = Integer.max(max, i[1]);
                }
                count++;
            }
        }
    }
}