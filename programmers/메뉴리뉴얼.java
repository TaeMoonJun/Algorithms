import java.util.*;

class 메뉴리뉴얼 {
    int[] max;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        max = new int[11];
        Map<Integer, Map> courseMap = new HashMap<>();

        for (int i : course) {
            courseMap.put(i, new HashMap<String, Integer>());
        }

        //각 주문에서
        //  2개, 3개, ... order.length개 조합 찾기
        for (String order : orders) {
            for (int i: course) {
                if (i > order.length()) {
                    break;
                }
                char[] order2 = order.toCharArray();
                Arrays.sort(order2);
                getCombination(courseMap.get(i), order2, new boolean[order.length()], i, 0);
            }
        }

        for (int i : course) {
            if (max[i] < 2) {
                continue;
            }
            Map<String, Integer> map = courseMap.get(i);
            for (String str : map.keySet()) {
                if (map.get(str) == max[i]) {
                    answer.add(str);
                }
            }
        }

        answer.sort(Comparator.naturalOrder());

        return answer.toArray(new String[0]);
    }

    void getCombination(Map<String, Integer> numMap, char[] order, boolean[] visited, int r, int depth) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(order[i]);
                }
            }
            String str = sb.toString();

            if (numMap.containsKey(str)) {
                numMap.put(str, numMap.get(str) + 1);
                max[str.length()] = Math.max(max[str.length()], numMap.get(str));
            } else {
                numMap.put(str, 1);
            }
            return;
        }

        if (depth < order.length) {
            visited[depth] = true;
            getCombination(numMap, order, visited, r - 1, depth + 1);
            visited[depth] = false;
            getCombination(numMap, order, visited, r, depth + 1);
        }
    }
}

// Map<Integer, Map<String, Integer>> 이렇게 복잡하게 저장할 필요가 없었음(사실 이것때문에 오래걸림)
// 그냥 Map<String, Integer> 이런식으로만하고 검사하면서 필요한것만 체크해서 사용하면 됐음
// 다시 풀기로 약속해요...