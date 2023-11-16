import java.util.*;

//1844
class 게임 맵 최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        return bfs(n, m, maps, visited);
    }

    int bfs(int n, int m, int[][] maps, boolean[][] visited){
        final int[] dx = new int[]{1, 0, -1, 0};
        final int[] dy = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            for(int i=0;i<4;i++){
                int nx = polled[0] + dx[i];
                int ny = polled[1] + dy[i];
                if(nx == m-1 && ny == n-1){
                    return polled[2] +1;
                }else if(nx <m && nx>=0 && ny <n && ny>=0){
                    if(!visited[ny][nx] && maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx,ny,polled[2]+1});
                    }
                }
            }
        }
        return -1;
    }
}
