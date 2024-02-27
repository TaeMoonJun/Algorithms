//12938
class 최고의집합 {
    public int[] solution(int n, int s) {
        int common = s / n;
        int left = s - common * n;
        if (common <= 0) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        for (int i = 0; i < n - left; i++) {
            answer[i] = common;
        }
        for (int i = n - left; i < n; i++) {
            answer[i] = common + 1;
        }

        return answer;
    }
}