import java.util.Arrays;

//42889
class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] clear = new int[N + 1];
        float[][] failRates = new float[N][2];

        for (int stage : stages) {
            clear[stage - 1]++;
        }

        for (int i = clear.length - 1; i >= 1; i--) {
            clear[i - 1] += clear[i];
        }

        for (int i = 0; i < failRates.length; i++) {
            failRates[i][0] = i + 1;
            if (clear[i] == 0) {
                failRates[i][1] = 0;
            } else {
                failRates[i][1] = (float) (clear[i] - clear[i + 1]) / clear[i];
            }
        }

        Arrays.sort(failRates, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return (int) (o1[0] - o2[0]);
            }
            return o1[1] < o2[1] ? 1 : -1;
        });

        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRates[i][0];
        }

        return answer;
    }
}