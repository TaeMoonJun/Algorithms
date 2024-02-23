import java.util.*;

//43163
class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        String[] beginWords = Arrays.copyOf(words, words.length + 1);
        beginWords[beginWords.length-1] = begin;

        boolean[][] graph = new boolean[beginWords.length][beginWords.length];

        for (int i = 0; i < beginWords.length; i++) {
            for (int j = i + 1; j < beginWords.length; j++) {
                if (isConnect(beginWords[i], beginWords[j])) {
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }

        boolean[] visited = new boolean[beginWords.length];
        visited[beginWords.length-1] = true;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{beginWords.length-1, 0});
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            for (int i = 0; i < beginWords.length-1; i++) {
                if (!visited[i] && graph[poll[0]][i]) {
                    if (beginWords[i].equals(target)) {
                        return poll[1] + 1;
                    }
                    queue.add(new Integer[]{i, poll[1] + 1});
                    visited[i] = true;
                }
            }
        }
        return answer;
    }

    boolean isConnect(String from, String to) {
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == to.charAt(i)) {
                count++;
            }
        }
        return count == from.length() - 1;
    }
}
//문제 좀 잘 읽읍시다 ㅋㅋㅋ
//begin은 words[]에 없었음