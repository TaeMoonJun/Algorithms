import java.util.Arrays;

//118668
class 코딩테스트공부 {
    static int[][] studies = new int[][]{{1, 0, 1}, {0, 1, 1}};

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 500;
        int maxA = alp, maxC = cop, n;
        for (int[] problem : problems) {
            maxA = Math.max(maxA, problem[0]);
            maxC = Math.max(maxC, problem[1]);
        }
        n = Math.max(maxA, maxC);

        int[][] ac = new int[n + 2][n + 2];
        for (int i = 0; i < ac.length; i++) {
            Arrays.fill(ac[i], 500);
        }
        ac[alp][cop] = 0;

        for (int i = alp; i < ac.length; i++) {
            for (int j = cop; j < ac.length; j++) {
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nAlp = Math.min(ac.length - 1, i + problem[2]);
                        int nCop = Math.min(ac.length - 1, j + problem[3]);
                        ac[nAlp][nCop] = Math.min(ac[nAlp][nCop], ac[i][j] + problem[4]);
                    }
                }
                for (int[] study : studies) {
                    int nAlp = Math.min(ac.length - 1, i + study[0]);
                    int nCop = Math.min(ac.length - 1, j + study[1]);
                    ac[nAlp][nCop] = Math.min(ac[nAlp][nCop], ac[i][j] + study[2]);
                }
            }
        }

        for (int i = maxA; i < ac.length; i++) {
            for (int j = maxC; j < ac.length; j++) {
                answer = Math.min(answer, ac[i][j]);
//                System.out.print(ac[i][j] + " ");
            }
//            System.out.println();
        }
        return answer;
    }
}

//알고력과 코딩력	0~150
//문제들		1~100
//기본으로 1시간에 1씩 올릴수 있음
//문제별 필요 알고력 코딩력 존재, 문제 풀 시 알고력, 코딩력 상승
//모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단시간 return
//
//dfs나 bfs는 안될것 같음!
//시간이나 알고력, 코딩력으로 봤을 때는 숫자가 안큼
//알고력*코딩력 -> 150*150
//시간	-> 150*2
//이럼 dp가 맞음
//
//시간으론 못할것 같고
//xy축을 알고력 코딩력으로 놓고 각 칸에서
//	문제들 + 기본공부 갱신
//150*150*100

//처음에 필요 알고, 코딩력보다 초기 알고력과 코딩력이 큰 경우 런타임 에러 났음 ㅋㅋ
//dp 자신없는데 생각 잘해서 잘푼듯!