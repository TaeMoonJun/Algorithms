//64062
class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0, max = 0, mid=0;

        for (int stone : stones) {
            max = Math.max(max, stone);
        }

        while(min <= max){
            int count = 0;
            mid = (max + min) / 2;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid <= 0) {
                    count++;
                    if (count >= k) {
                        break;
                    }
                } else {
                    count = 0;
                }
            }

            if (count >= k) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}
// 이게 왜 이분탐색만으로??