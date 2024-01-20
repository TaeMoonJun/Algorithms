import java.util.*;

//258709
class 주사위고르기 {
    public int[] solution(int[][] dice) {
        List<List<Integer>> combinations = new ArrayList<>();
        int max = -1;
        int[] answer = new int[dice.length];

        combination(combinations, dice.length, 0, 0, new boolean[dice.length]);
        for (List<Integer> combi : combinations) {
            List<Integer> contrast = new ArrayList<>();

            for (int i = 0; i < dice.length; i++) {
                if (!combi.contains(i)) {
                    contrast.add(i);
                }
            }

            int[] a = getResults(dice, combi, new ArrayList<>());
            int[] b = getResults(dice, contrast, new ArrayList<>());
            int win=0, indexB = 0;

            for (int i = 0; i < a.length; i++) {
                while (indexB < b.length && a[i] > b[indexB]) {
                    indexB++;
                }
                win += indexB;
            }

            if (win > max) {
                max = win;
                answer = combi.stream().mapToInt(i -> i+1).toArray();
            }
        }

        return answer;
    }

    int[] getResults(int[][] dice, List<Integer> selected, List<Integer> results) {
        rollDice(dice, 0, 0, selected, results);
        return results.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    void rollDice(int[][] dice, int depth, int sum, List<Integer> selected, List<Integer> results) {
        if (depth == dice.length / 2) {
            results.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            rollDice(dice, depth+1, sum + dice[selected.get(depth)][i], selected, results);
        }
    }

    void combination(List<List<Integer>> list, int n, int start, int depth, boolean[] visited) {
        if (depth == n/2) {
            List<Integer> combi = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    combi.add(i);
                }
            }
            list.add(combi);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(list, n, i + 1, depth + 1, visited);
                visited[i] = false;
            }
        }
    }
}
//n개의 육면주사위, 임의의 눈
//반씩 가져가서 하나씩 굴리기
//승리할 확률이 가장 높은 주사위 구성 오름차순 리턴
//
//n 2~10
//
//6^10 -> 완탐 가능
//1. 조합으로 주사위 가져가기
//2. 주사위 조합에서 완탐
//	A 조합에서 가능한 sum, B 조합에서 가능한 sum
//3. 승수 계산
//
//19~26 시간초과
//해결법...
//개선 1. 주사위의 반을 선택하므로 나머지 반은 다시 계산할 필요 없음
//  여전히 안됨
//
//현재 시간복잡도
//주사위 조합 10C5 -> 252 -> 반만 봐도 됨 -> 126
//	*(
//	조합에서 굴렸을때 나온 값 경우의 수 -> 6^5+6^5 -> n
//	+
//	굴려서 나온 값 비교 -> 6^5*6^5  ->  n^2
//	)
//
//개선 2. 굴려서 나온 값 정렬 + 투포인터 n
//  -> n*log n
//비교하는 부분의 시간복잡도를 너무 가볍게 생각했다...