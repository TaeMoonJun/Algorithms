import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {   // 이름->번호 맵
            map.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {   // 칫솔판매금
            calReturn(map.get(seller[i]), amount[i] * 100, referral, answer, map);
        }

        return answer;
    }

    void calReturn(int member, int income, String[] referral, int[] answer, Map<String, Integer> map) {
        int taking = (int) (income * 0.1);
        answer[member] += income - taking;

        if (taking != 0 && map.containsKey(referral[member])) {
            calReturn(map.get(referral[member]), taking, referral, answer, map);
        }
    }
}