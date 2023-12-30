import java.util.ArrayList;

//60061
class 기둥과보설치 {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] pillar = new boolean[n+2][n+2];
        boolean[][] bo = new boolean[n+2][n+2];

        for (int[] build : build_frame) {
            if (build[3] == 1) {    // 설치
                if (build[2] == 0) {  // 기둥
                    buildPillar(pillar, bo, build[0]+1, build[1]+1);
                } else { //보
                    buildBo(pillar, bo, build[0]+1, build[1]+1);
                }

            } else {    //삭제
                if (build[2] == 0) {  // 기둥
                    deletePillar(pillar, bo, build[0]+1, build[1]+1);
                } else { //보
                    deleteBo(pillar, bo, build[0]+1, build[1]+1);
                }
            }
        }

        ArrayList<int[]> answer = new ArrayList<>();
        for (int i = 0; i < pillar.length; i++) {
            for (int j = 0; j < pillar.length; j++) {
                if (pillar[i][j]) {
                    answer.add(new int[]{i-1, j-1, 0});
//                    System.out.println("pillar " + i + " " + j);
                }
                if (bo[i][j]) {
                    answer.add(new int[]{i-1, j-1, 1});
//                    System.out.println("bo " + i + " " + j);
                }
            }
        }

        return answer.toArray(int[][]::new);
    }

    boolean checkPillar(boolean[][] pillar, boolean[][] bo, int x, int y) {
        if (y == 1 || (bo[x - 1][y]) || bo[x][y] || pillar[x][y - 1]) {
            return true;
        }
        return false;
    }

    boolean checkBo(boolean[][] pillar, boolean[][] bo, int x, int y) {
        if (pillar[x][y - 1] || pillar[x + 1][y - 1] || (bo[x - 1][y] && bo[x + 1][y])) {
            return true;
        }
        return false;
    }

    //기둥	바닥, 보, 기둥 위에 있어야함
    //보	한쪽이 기둥 위 또는 양쪽이 보에 연결
    void buildPillar(boolean[][] pillar, boolean[][] bo, int x, int y) {
        if (checkPillar(pillar, bo, x, y)) {
            pillar[x][y] = true;
        }
    }

    void buildBo(boolean[][] pillar, boolean[][] bo, int x, int y) {
        if (checkBo(pillar, bo, x, y)) {
            bo[x][y] = true;
        }
    }

    void deletePillar(boolean[][] pillar, boolean[][] bo, int x, int y) {
        pillar[x][y] = false;

        for (int i = 0; i < pillar.length; i++) {
            for (int j = 0; j < pillar.length; j++) {
                if ((pillar[i][j] && !checkPillar(pillar, bo, i, j)) ||
                        (bo[i][j] && !checkBo(pillar, bo, i, j))) {
                    pillar[x][y] = true;
                    return;
                }
            }
        }

//        // 위에 기둥이 있을때
//        if (pillar[x][y + 1] && !checkPillar(pillar, bo, x, y+1)) {
//            pillar[x][y] = true;
//            return;
//        }
//
//        // 왼쪽 위 보
//        if (bo[x - 1][y + 1] && !checkBo(pillar, bo,x-1, y+1)) {
//            pillar[x][y] = true;
//            return;
//        }
//        // 위 보
//        if (bo[x][y + 1] && !checkBo(pillar, bo, x, y+1)) {
//            pillar[x][y] = true;
//        }
    }

    void deleteBo(boolean[][] pillar, boolean[][] bo, int x, int y) {
        bo[x][y] = false;

        for (int i = 0; i < pillar.length; i++) {
            for (int j = 0; j < pillar.length; j++) {
                if ((pillar[i][j] && !checkPillar(pillar, bo, i, j)) ||
                        (bo[i][j] && !checkBo(pillar, bo, i, j))) {
                    bo[x][y] = true;
                    return;
                }
            }
        }

//        // 기둥이 있을때
//        if (pillar[x][y] && !checkPillar(pillar, bo, x, y)) {
//            bo[x][y] = true;
//            return;
//        }
//        // 오른쪽 위에 기둥이 있을떄
//        if (pillar[x+1][y] && !checkPillar(pillar, bo, x+1, y)) {
//            bo[x][y] = true;
//            return;
//        }
//        // 왼쪽 보 있을때
//        if (!bo[x - 1][y] && !checkBo(pillar, bo, x-1, y)) {
//            bo[x][y] = true;
//            return;
//        }
//        // 오른쪽 보 있을 때
//        if (bo[x+1][y] && !checkBo(pillar, bo, x+1, y)) {
//            bo[x][y] = true;
//        }
    }
}

//기둥은 점에서 위, 보는 점에서 오른쪽으로
//기둥	바닥, 보, 기둥 위에 있어야함
//보	한쪽이 기둥 위 또는 양쪽이 보에 연결
//벽면의 크기 n	5~100
//build_frame	1~1000
//	x, y, 0 기둥1보, 0삭제1설치
//
//벽면 벗어나거나 구조물 겹치도록 설치하는 경우 없음
//
//return
//	[x, y, 0기둥1보]
//	x, y 오름차순, 같으면 기둥 우선

// 나는 진짜 억울해 왜 주석처리한대로 검사하면 안되는거야...