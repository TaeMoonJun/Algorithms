//161988
class 연속펄스부분수열의합 {
    int[] pulse = new int[]{1, -1};
    public long solution(int[] sequence) {
        Long[] minusStart = new Long[sequence.length+1];
        Long[] plusStart = new Long[sequence.length+1];
        minusStart[0] = 0L;
        plusStart[0] = 0L;
        long answer = Math.max(sequence[0], -sequence[0]);

        for (int i = 0; i < sequence.length; i++) {
            plusStart[i + 1] = plusStart[i] + (long) sequence[i] * pulse[i % 2];
            minusStart[i + 1] = minusStart[i] + (long) sequence[i] * pulse[(i+1) % 2];
        }

        Long minusSmall = 0L, minusBig = 0L;
        Long plusSmall = 0L, plusBig = 0L;
        for (int i = 1; i < sequence.length + 1; i++) {
            if (minusSmall > minusStart[i]) {
                minusSmall = minusStart[i];
            } else if (minusBig < minusStart[i]) {
                minusBig = minusStart[i];
                answer = Math.max(answer, minusBig - minusSmall);
//                System.out.println("Minus "+(minusBig - minusSmall));
            }

            if (plusSmall > plusStart[i]) {
                plusSmall = plusStart[i];
            } else if (plusBig < plusStart[i]) {
                plusBig = plusStart[i];
                answer = Math.max(answer, plusBig - plusSmall);
//                System.out.println("Plus "+(plusBig-plusSmall));
            }
        }

        return answer;
    }
}
//누적합
//Long으로 ㅋㅋ