import java.util.*;

//118669
class 등산코스정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[]{50001, 10000000};
        ArrayList<ArrayList<Integer[]>> map = new ArrayList<>(n);
        Set<Integer> summitSet = new HashSet<>();

        for (int i:summits) {
            summitSet.add(i - 1);
        }

        for(int i=0;i<n;i++){
            map.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            map.get(path[0] - 1).add(new Integer[]{path[1] - 1, path[2]});
            map.get(path[1] - 1).add(new Integer[]{path[0] - 1, path[2]});
        }

        boolean[] visited = new boolean[n];
        int[] maxDist = new int[n];
        Arrays.fill(maxDist, 10000001);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int gate : gates) {
            pq.add(new Integer[]{gate - 1, 0});
        }

        while(!pq.isEmpty()){
            Integer[] place = pq.poll();
            if (place[1] > answer[1]) {
                break;
            }
            if(visited[place[0]]){
                continue;
            }
            visited[place[0]] = true;

            if(maxDist[place[0]] > place[1]){
                maxDist[place[0]] = place[1];
                if(summitSet.contains(place[0])){   // 도착한 곳이 정상
                    if (answer[1] > place[1]) {
                        answer[0] = place[0]+1;
                        answer[1] = maxDist[place[0]];
                    } else if(answer[0] > place[0]+1){
                        answer[0] = place[0]+1;
                    }
                }else { //정상은 아니야
                    for(int j=0;j<map.get(place[0]).size();j++){
                        int next = map.get(place[0]).get(j)[0];
                        int max = Math.max(place[1], map.get(place[0]).get(j)[1]);
                        if(!visited[next] && max <= answer[1]){
                            pq.add(new Integer[]{next, max});
                        }
                    }
                }
            }
        }

        return answer;
    }
}
// 1. gate별로 for문안에서 진행할 필요 없이 큐에 gate별 시작만 넣어놓으면 됐음    시간초과
// 2. graph를 2차원 배열로 했으면 50000^2, 2중 ArrayList에 장소와 비용을 담으면 200000*4    메모리 초과