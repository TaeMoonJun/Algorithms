import java.util.*;

//92343
class 양과늑대 {
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();

        map.put(0, new Node(0, 0));
        list.add(map.get(0));

        for (int i = 1; i < info.length; i++) {
            Node node = new Node(i, info[i]);
            map.put(i, node);
        }

        for (int i = 0; i < edges.length; i++) {
            Node parent = map.get(edges[i][0]);
            Node child = map.get(edges[i][1]);
            parent.children.add(child);
        }

        dfs(list, 0, 0);

        return answer;
    }

    void dfs(ArrayList<Node> list, int sheep, int wolf) {
        if (wolf !=0 && sheep <= wolf) {
            answer = Math.max(answer, sheep);
            return;
        } else if (list.isEmpty()) {
            answer = Math.max(answer, sheep);
        }

        for (Node node : list) {
            ArrayList<Node> list2 = new ArrayList<>(list);
            list2.remove(node);
            list2.addAll(node.children);
            if (node.type == 0) {
                dfs(list2, sheep + 1, wolf);
            } else {
                dfs(list2, sheep, wolf + 1);
            }
        }
    }
}

class Node {
    int num;
    int type;
    ArrayList<Node> children = new ArrayList<>();

    Node(int num, int type) {
        this.num = num;
        this.type = type;
    }
}

//최초생각
//1. 수학적인 법칙이 있을까 -> 못 찾음
//2. Node 클래스에 정보를 잘 저장해서 그리디로 가능하게하자
//	0. 노드 번호
//	1. 양 늑대 구분
//	2. 자식
//	3. 밑으로 가장 가까운 양 거리 <- 이걸 우선순위로 접근
//
//  1,2,3로 정렬하는 PriorityQueue에 루트부터 시작해
//  방문한 노드의 자식들 추가하면서
//
//  -> 가장 가까운 양 거리가 같아도 그 레벨에 수가 다를 수 있음(짧은 생각)
//	  -> 가장 가까운 양 거리 겹칠때 몇 마리인지도 확인하여 정렬
//	  -> 그렇게 그리디하게 접근해도 그 바로 아래 레벨은 사정이 다를수 있음
//	  83.3/100점
//
//3. DFS. 근데 지금까지 굳이 안 쓴 이유??
//	1. 5번 문제인데 그렇게 쉽게??
//	2. 2번 방법을 생각하면서 방문한 노드는 제외하면서 Queue에서 뽑아쓰는 방식을
//	생각했는데 그 방법을 생각하기 전에 dfs면 방문이 많을것 같아서...
//	n=17인데요? -> 그러게요...
//
//  dfs 인자인 list에 동적으로 추가 삭제하려다가 좀 절었다
//  그냥 새 리스트 만들어서 전달하면 되는 문제