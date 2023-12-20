import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//92341
class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        //Map으로 차량번호별 입차시간
        //Map으로 차량번호별 누적 주차 시간
        Map<String, String> parkMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        int[] answer;

        for (String record : records) {
            String[] s = record.split(" ");

            if (s[2].equals("IN")) {
                parkMap.put(s[1], s[0]);
            } else {
                String[] in = parkMap.get(s[1]).split(":");
                String[] out = s[0].split(":");
                int minute = (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60
                        + Integer.parseInt(out[1]) - Integer.parseInt(in[1]);

                if (timeMap.containsKey(s[1])) {
                    timeMap.put(s[1], minute + timeMap.get(s[1]));
                } else {
                    timeMap.put(s[1], minute);
                }
                parkMap.remove(s[1]);   //	출차했으면 삭제
            }
        }

        for (String s : parkMap.keySet()) { //	마지막에 남은것들 23:59로 출차처리
            String[] in = parkMap.get(s).split(":");
            int[] out = new int[]{23, 59};
            int minute = (out[0] - Integer.parseInt(in[0])) * 60
                    + out[1] - Integer.parseInt(in[1]);

            if (timeMap.containsKey(s)) {
                timeMap.put(s, minute + timeMap.get(s));
            } else {
                timeMap.put(s, minute);
            }
        }

        int count = 0;
        answer = new int[timeMap.size()];
        Iterator<String> it = timeMap.keySet().stream().sorted().iterator();  // 시간 금액 계산
        while (it.hasNext()) {
            answer[count++] = chargeCompute(fees, timeMap.get(it.next()));
        }

        return answer;
    }

    int chargeCompute(int[] fees, int minute) {
        int fee = fees[1];

        if (minute > fees[0]) {
            fee += (minute - fees[0]) / fees[2] * fees[3];
            if ((minute - fees[0]) % fees[2] != 0) {
                fee += fees[3];
            }
        }
        return fee;
    }
}