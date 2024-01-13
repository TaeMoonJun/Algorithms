import java.util.*;

class 여행경로 {
    ArrayList<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];

        ArrayList<String> start = new ArrayList<>();
        start.add("ICN");
        dfs(tickets, used, start);

        return answer.toArray(String[]::new);
    }

    void dfs(String[][] tickets, boolean[] used, ArrayList<String> list) {
        if (list.size() == tickets.length + 1) {
//            System.out.println(list);
            if (answer.isEmpty()) {
                answer = new ArrayList<>(list);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).compareTo(answer.get(i)) > 0) {
                        return;
                    } else if (list.get(i).compareTo(answer.get(i)) < 0) {
                        answer = new ArrayList<>(list);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(list.get(list.size() - 1)) && !used[i]) {
                list.add(tickets[i][1]);
                used[i] = true;

                dfs(tickets, used, list);

                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
// 멍청 포인트
// n 최대 10000이라 n^2 해도 되는데 막 방법 생각하고 있었음