class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        boolean[][] water = new boolean[n][m];

        for(int i=0;i<puddles.length;i++){
            water[puddles[i][1]-1][puddles[i][0]-1] = true;
        }

        for(int i=0;i<n;i++){
            if(water[i][0]){
                map[i][0] = 0;
            }else if(i!=0 && map[i-1][0]==0){
                map[i][0] = 0;
            }
            else{
                map[i][0] = 1;
            }
        }
        for(int i=0;i<m;i++){
            if(water[0][i]){
                map[0][i] = 0;
            }else if(i!=0 && map[0][i-1]==0){
                map[0][i] = 0;
            }
            else{
                map[0][i] = 1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(water[i][j]){
                    map[i][j] = 0;
                } else{
                    map[i][j] = (map[i-1][j] + map[i][j-1])%1000000007;
                }
            }
        }

        return map[n-1][m-1];
    }
}
// 처음 초기화를 너무 못했어
// 중간에 되돌아가기 귀찮아서 그대로했는데
// 0으로 배열 첫줄 패딩하고 추가적인 boolean 배열 없이 -1인지 확인으로 할걸...