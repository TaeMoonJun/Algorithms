import java.util.Arrays;

//42884
class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int answer = 1, end = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if(routes[i][0] > end){
                end = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
// 테스트케이스만 보고 쉽게 생각하거나 속으면 안되는데
// 테스트케이스는 시작으로만 정렬하면 끝도 정렬되는 예시였는데 실제로는 그렇지 않음
// 현재까지의 끝 지점과 다음 시작 지점만 고려하면 됨