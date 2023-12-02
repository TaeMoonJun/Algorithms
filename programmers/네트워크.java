//43162
class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, computers, i);
                count++;
            }
        }

        return count;
    }

    void dfs(boolean[] visited, int[][] computers, int target) {
        visited[target] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[target][i] == 1 && !visited[i]) {
                dfs(visited, computers, i);
            }
        }
    }
}