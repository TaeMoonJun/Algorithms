//150365
class 미로탈출명령어 {
    static int[] dx = new int[]{1, 0, 0, -1};
    static int[] dy = new int[]{0, -1, 1, 0};
    static char[] command = new char[]{'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Character[] commands = new Character[k];
        int dist = Math.abs(r - x) + Math.abs(c - y);

        if (k >= dist && (k - dist) % 2 == 0) {
            dfs(n, m, x, y, r, c, k, commands, 0);
        } else {
            return "impossible";
        }

        StringBuilder sb = new StringBuilder();
        for (char com : commands) {
            sb.append(com);
        }

        return sb.toString();
    }

    void dfs(int n, int m, int x, int y, int r, int c, int k, Character[] commands, int count) {
        if (count == k || commands[commands.length-1] != null) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                if (Math.abs(r - nx) + Math.abs(c - ny) > k - (count + 1)) {
                    continue;
                }
                if (commands[commands.length - 1] != null) {
                    break;
                }

                commands[count] = command[i];
                dfs(n, m, nx, ny, r, c, k, commands, count+1);
            }
        }
    }
}

//    n m	격자	2~50
//    x y	현위치
//    r c	목표위치
//    k	이동횟수	1~2500
//
//    rc에서 끝나기만하면 됨
//    사전순으로 빠른거 출력 d l r u	하 좌 우 상
//    못가면 impossible

// 중복 가능이니까 bfs 무의미 -> 사전순 dfs
// 못 가는 조건
//1. (k - 거리) 0 또는 2의 배수여야함
//2. k >= 거리

// 1. 예시 데이터가 좌측상단이 1,1이었고 xy도 돌아가있었음;;;
// 2. String은 불변이라 값 전달할거면 StringBuilder나 Buffer 써야함 (그냥 char[] 사용)