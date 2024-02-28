class 거스름돈 {
    public int solution(int n, int[] money) {
        int[] answer = new int[n + 1];

        for (int m : money) {
            if (m <= n) {
                answer[m]++;
            }
            for (int i = 1; i+m < answer.length; i++) {
                answer[i + m] = (answer[i + m] + answer[i]) % 1000000007;
            }
        }

        return answer[n];
    }
}