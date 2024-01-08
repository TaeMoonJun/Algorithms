import java.util.*;

//258711
class 도넛과막대그래프 {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> contrastGraph = new ArrayList<>();
        Set<Integer> stick = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {    // 들어오는 간선과 나가는 간선
            while (graph.size() < edges[i][0]) {
                graph.add(new ArrayList<>());
            }
            while (contrastGraph.size() < edges[i][1]) {
                contrastGraph.add(new ArrayList<>());
            }
            graph.get(edges[i][0] - 1).add(edges[i][1] - 1);
            contrastGraph.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }

        if (graph.size() > contrastGraph.size()) {  //마지막 번호의 노드에 들어오거나 나가는 간선 없을때의 처리
            contrastGraph.add(new ArrayList<>());
        } else {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < contrastGraph.size(); i++) {
            if (contrastGraph.get(i).isEmpty()) {   // 들어오는 간선이 없고
                if (graph.get(i).size() >= 2) {     // 나가는 간선이 2개 이상이면 시작 정점
                    answer[0] = i;
                } else {                            // 그 미만이면 시작에 직접 이어지지 않은 막대의 시작 정점
                    stick.add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (Integer i : stick) {   // 시작에 직접 이어지지 않은 막대 시작 정점 처리
            ArrayList<Integer> next = graph.get(i);
            visited.add(i);

            while (!next.isEmpty()) {
                int v = next.get(0);
                visited.add(v);
                next = graph.get(v);
            }
            answer[2]++;
        }

        for (Integer i : graph.get(answer[0])) {    // 시작에 이어진 그래프들 처리
            if (visited.contains(i)) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            int vSum = 0, eSum = 0;

            visited.add(i);
            queue.add(i);
            while (!queue.isEmpty()) {
                int j = queue.poll();
                vSum++;

                List<Integer> next = graph.get(j);
                for (int k = 0; k < next.size(); k++) {
                    eSum++;
                    if (!visited.contains(next.get(k))) {
                        queue.add(next.get(k));
                        visited.add(next.get(k));
                    }
                }
            }

            if (vSum == eSum) {
                answer[1]++;
            } else if (vSum == eSum + 1) {
                answer[2]++;
            } else {
                answer[3]++;
            }
        }

        answer[0]++;
        return answer;
    }
}

//도넛 모양		n개 정점, n개 간선		대충 싸이클
//막대 모양		n개 정점, n-1개 간선	그냥 1자
//8자 모양		2n+1개 정점, 2n+2개 간선	하나의 정점에 두개 도넛
//간선은 방향있음
//
//각 모양 그래프 판별 함수?
//일단 중앙 정점은 들어오는 간선 없고, 나가는 간선 두개 이상
//	그거하면 탐색만 하면 한번에 탐색한 정점, 간선 수로 판별가능
//	-> 그래프 판별이 숫자로만 가능함
//
//문제상황!
//도넛과 8자는 싸이클 형성해서 상관이 없는데
//	막대는 시작하는 정점부터 가지 않으면 다 못 돌음
//나가는 간선이 1개이고 들어오는 간선이 없는게 막대의 시작 정점

//뭔가 어렵게 푼것 같은데 저번엔 2번 문제 주제에 손도 못 댔으니까...
//성장했다고 보겠습니다!