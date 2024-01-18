import java.util.PriorityQueue;

//72414
class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        String[] play = play_time.split(":");
        int n = Integer.parseInt(play[0]) * 60 * 60
                + Integer.parseInt(play[1]) * 60 + Integer.parseInt(play[2]);
        int[] time = new int[n];
        PriorityQueue<Integer> startQ = new PriorityQueue<>();
        PriorityQueue<Integer> endQ = new PriorityQueue<>();

        for (String log : logs) {
            String[] str = log.split("-");
            String[] strStart = str[0].split(":");
            String[] strEnd = str[1].split(":");
            startQ.add(Integer.parseInt(strStart[0]) * 60 * 60
                    + Integer.parseInt(strStart[1]) * 60 + Integer.parseInt(strStart[2]));
            endQ.add(Integer.parseInt(strEnd[0]) * 60 * 60
                    + Integer.parseInt(strEnd[1]) * 60 + Integer.parseInt(strEnd[2]));
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!endQ.isEmpty() && endQ.peek() == i) {
                endQ.poll();
                count--;
            }
            while (!startQ.isEmpty() && startQ.peek() == i) {
                startQ.poll();
                count++;
            }

            time[i] = count;
        }

        String[] adv = adv_time.split(":");
        int windowSize = Integer.parseInt(adv[0]) * 60 * 60
                + Integer.parseInt(adv[1]) * 60 + Integer.parseInt(adv[2]);
        long sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += time[i];
        }

        long max = sum, start = 0;

        for (int i = windowSize; i < n; i++) {
            sum += time[i];
            sum -= time[i - windowSize];
            if (sum > max) {
                max = sum;
                start = i - windowSize+1;
//                System.out.println(start+" "+max);
            }
        }

        int h = (int) (start / 60 / 60);
        int m = (int) ((start - h * 60 * 60) / 60);
        int s = (int) (start - h * 60 * 60 - m * 60);

        StringBuilder answer = new StringBuilder();
        if (h / 10 == 0) {
            answer.append(0);
        }
        answer.append(h).append(":");
        if (m / 10 == 0) {
            answer.append(0);
        }
        answer.append(m).append(":");
        if (s / 10 == 0) {
            answer.append(0);
        }
        answer.append(s);
        return answer.toString();
    }
}
//play_time	재생시간
//adv_time	광고시간	00:00:01~99:59:59
//logs	시청자 재생구간	1~300,000
//		HH:MM:SS-HH:MM:SS
//
//처음 풀때는 0초, 모든 시청 시작, 종료 시간을 기점으로
//광고 삽입을 해서 각각 시간계산
//
//
//시청자 재생구간 수가 300,000
//maximum 동영상 길이 60*60*99 -> 356,400
//그냥 초로 보면서 sliding window

//sum을 long으로 안해서 한문제 틀렸었음