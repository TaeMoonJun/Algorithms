import java.util.HashSet;
import java.util.Set;

//49191
class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set<Integer>[] winSets = new HashSet[n+1];
        Set<Integer>[] loseSets = new HashSet[n+1];
        boolean[] winVisited = new boolean[n + 1];
        boolean[] loseVisited = new boolean[n + 1];

        for (int i = 1; i < n+1; i++) {
            winSets[i] = new HashSet<>();
            loseSets[i] = new HashSet<>();
        }

        for (int[] result : results) {
            winSets[result[0]].add(result[1]);
            loseSets[result[1]].add(result[0]);
        }

        for (int i = 1; i < n + 1; i++) {
            updateSet(winVisited, winSets, i);
            updateSet(loseVisited, loseSets, i);
            if (winSets[i].size() + loseSets[i].size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    void updateSet(boolean[] visited, Set<Integer>[] sets, int index) {
        Set<Integer> temp = new HashSet<>(sets[index]);
        for (Integer next : temp) {
            if (!visited[next] && !sets[next].isEmpty()) {
                updateSet(visited, sets, next);
            }
            sets[index].addAll(sets[next]);
        }
        visited[index] = true;
    }
}
// 처음에 updateSet 함수 내용을 중복해서 적다가 정신차렸음