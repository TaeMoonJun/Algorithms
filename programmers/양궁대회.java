import java.util.Arrays;

//92342
class 양궁대회 {
    int diff = -100;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        int[] result = new int[11];
        dfs(n, info, 0, n, result);
        return answer;
    }

    void dfs(int n, int[] info, int depth, int arrow, int[] result) {
        if (arrow == 0) {
            int ryan = 0, apeach = 0;
            for (int i = 0; i < 11; i++) {
                if (result[i] > info[i]) {
                    ryan += 10 - i;
                } else if (info[i] != 0) {
                    apeach += 10 - i;
                }
            }
            if (ryan > apeach) {    // 이기긴 함
                if (diff < ryan - apeach) { // 점수차 갱신
                    diff = ryan - apeach;
                    answer = Arrays.copyOf(result, result.length);
                } else if (diff == ryan - apeach) {
                    for (int j = 10; j >= 0; j--) {
                        if (answer[j] > result[j]) {
                            return;
                        } else if (answer[j] < result[j]) {
                            break;
                        }
                    }
                    answer = Arrays.copyOf(result, result.length);
                }
            }
            return;
        }


        // 선택지
        // 1. 안쏘기
        // 2. 어피치보다 1 많이 쏘기
        // depth 10에서는 다 쏴버리기
        if (depth == 10) {
            result[depth] += arrow;
            dfs(n, info, depth + 1, 0, result);
            result[depth] -= arrow;
        } else {
            dfs(n, info, depth + 1, arrow, result);

            int shot = Math.min(info[depth] + 1, arrow);
            result[depth] += shot;
            dfs(n, info, depth + 1, arrow - shot, result);
            result[depth] -= shot;
        }
    }
}

//어피치가 먼저 쏨
//점수별로 라이언이 많이 쏜경우 아니면 어피치가 점수 가져감
//1. 점수차
//2. 작은 점수에 많이 맞춘순으로

// 시간복잡도 정확히 모르겠으나 커보이진 않음 -> dfs

// 1. apeach 도 못맞췄으면 서로 0점인데 빼먹었었음
// 2. 작은 점수 많이 맞춘순에서 조건문 하나 빼먹음