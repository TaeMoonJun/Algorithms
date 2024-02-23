import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//42628
class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqRev = new PriorityQueue<>(Comparator.reverseOrder());

        for (String o : operations) {
            if (o.charAt(0) == 'I') {   //삽입
                int num = Integer.parseInt(o.substring(2));
                pq.add(num);
                pqRev.add(num);
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            } else if (o.charAt(2) == '1') {    //최댓값 삭제
                while (!pqRev.isEmpty() && map.get(pqRev.peek()) == 0) {
                    Integer poll = pqRev.poll();
                    map.put(poll, Math.max(map.get(poll) - 1, 0));
                }
                if (!pqRev.isEmpty()) {
                    Integer poll = pqRev.poll();
                    map.put(poll, Math.max(map.get(poll) - 1, 0));
                }
            } else if (o.charAt(2) == '-') { //최솟값 삭제
                while (!pq.isEmpty() && map.get(pq.peek()) == 0) {
                    Integer poll = pq.poll();
                    map.put(poll, Math.max(map.get(poll) - 1, 0));
                }
                if (!pq.isEmpty()) {
                    Integer poll = pq.poll();
                    map.put(poll, Math.max(map.get(poll) - 1, 0));
                }
            }
        }

        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (map.get(poll) != 0) {
                answer[0] = poll;
                answer[1] = poll;
                break;
            }
        }
        while (!pqRev.isEmpty()) {
            Integer poll = pqRev.poll();
            if (map.get(poll) != 0) {
                answer[0] = poll;
                break;
            }
        }

        return answer;
    }
}
//Map과 PQ 2개
//맵으로 숫자가 몇개 남았는지
//insert시 ++, delete시 --
//delete시 0이면 (이미 다른 pq에서 삭제) 무시