import java.util.Arrays;

//12927
class 야근지수 {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int max = works[works.length - 1], maxCount = 0, minusOneCount = 0;

        for (int i = works.length - 2; i >= 0; i--) {
            int product = works.length - 1 - i;
            if (n < product * (max - works[i])) {   // 이전까지의 값들을 현재 값으로 못 만들때
                int commonMinus = n / product;
                max -= commonMinus;
                minusOneCount = n - commonMinus * product;
                maxCount = product - minusOneCount;

                Long answer = cal(max, maxCount, minusOneCount);
                for (int j = 0; j <= i; j++) {
                    answer += (long) works[j] * works[j];
                }
                return answer;

            } else {
                n -= (max - works[i]) * product;
                max = works[i];
                maxCount = product;
            }
        }

        if (n > 0) {
            int commonMinus = n / works.length;
            max -= commonMinus;
            minusOneCount = n-commonMinus* works.length;
            maxCount = works.length - minusOneCount;
        }
        Long answer = cal(max, maxCount, minusOneCount);
        for (int j = 0; j < works.length - maxCount - minusOneCount; j++) {
            answer += (long) works[j] * works[j];
        }
//        System.out.println(max +" "+maxCount+" "+minusOneCount);
//        System.out.println(answer);
        return answer;

    }

    Long cal(int max, int maxCount, int minusOneCount) {
        if (max <= 0) {
            return 0L;
        }
        return (long) max * max * maxCount + (long) (max - 1) * (max - 1) * minusOneCount;
    }
}
//자료구조를 사용해서 풀었어야했나...
//그저 수학계산... (+하나하나 계산 안할 방법 찾기)
//자료구조 쓰면 보통 힙 사용하는듯