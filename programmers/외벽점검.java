import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//60062
class 외벽점검 {
    public int solution(int n, int[] weak, int[] dist) {
        Queue<List<Integer>> queue = new LinkedList<>();

        for (int i = 1; i < dist.length+1; i++) {
            friends(queue, i, 0, new boolean[dist.length], new LinkedList<>());

            while (!queue.isEmpty()) {
                List<Integer> seq = queue.poll();
//                System.out.println(seq);

                for (int j = 0; j < weak.length; j++) {   //j가 시작지점
                    int index = j, count = 0;

                    for (Integer integer : seq) {
                        int end = weak[index] + dist[integer];

                        while (weak[index] <= end) {
                            index++;
                            count++;
                            if (index >= weak.length) {
                                index = 0;
                                end -= n;
                            }
                        }

                        if (end > n) {
                            count += weak.length - index;
                            index = 0;
                        }

                    }
                    if (count == weak.length) {
                        return seq.size();
                    }
                }
            }
        }

        return -1;
    }

    void friends(Queue<List<Integer>> queue, int n, int depth, boolean[] visited, List<Integer> result) {
        if (depth == n) {
            queue.add(new LinkedList<>(result));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);
                friends(queue, n, depth + 1, visited, result);

                visited[i] = false;
                result.remove((Integer) i);
            }
        }
    }
}

//숫자가 굉장히 귀엽다 -> 완탐을 해도 되겠는걸요?
//순열로 친구 순서
//시작지점은 방문 못한 가장 낮은 취약지점부터
//
//정해진 친구 순서에서
//	시작지점 0부터 하나씩에 대해
//		다음 친구로 넘어가면서
//			다음에 거쳐야 할 지점 + 친구의 거리 -> 지점 어디까지 지났는지 갱신

//쉽게했지만 외벽 원이라고 살짝 얼탐