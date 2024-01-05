import java.util.*;

//42890
class 후보키 {
    Set<List<Integer>> candidateSet = new HashSet<>();

    public int solution(String[][] relation) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int n = relation[0].length;

        for (int i = 1; i < n + 1; i++) {
            combination(new boolean[n], i, 0, 0, queue);

            while (!queue.isEmpty()) {
                Set<String> set = new HashSet<>();
                List<Integer> list = queue.poll();

                for (int j = 0; j < relation.length; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer select : list) {
                        sb.append(relation[j][select]);
                    }
                    if (set.contains(sb.toString())) {
                        break;
                    } else {
                        set.add(sb.toString());
                    }

                    if (j == relation.length - 1) {
                        candidateSet.add(list);
                    }
                }
            }
        }

        return candidateSet.size();
    }

    void combination(boolean[] visited, int r, int start, int depth, Queue<List<Integer>> queue) {
        if (depth == r) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i< visited.length;i++) {
                if (visited[i]) {
                    list.add(i);
                }
            }

            for (List<Integer> temp : candidateSet) {
                if (list.containsAll(temp)) {
                    return;
                }
            }
            queue.add(list);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(visited, r, start + 1, depth + 1, queue);
                visited[i] = false;
            }
        }
    }
}
//테이블 주어졌을때 후보 키의 개수 return
//
//비슷한 문제 본적이 있는듯
//그것도 쿼리문 비슷한 거였는데 -> Set, Map으로 풀었었음
//combination r=1부터 올려가면서
//이미 후보키가 된건 이후에 뽑히면 안됨 -> containsAll

//나는 내 풀이에 만족해...