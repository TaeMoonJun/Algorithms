class Solution {
    static int[][] next = new int[][]{{0,1}, {0, -1},{1,0},{-1,0}};
    static int[][] diag = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[]{1,1,1,1,1};

        for(int i=0;i<places.length;i++){
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    if(places[i][j].charAt(k) == 'P'){
                        if(!check(j,k, places[i])){
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

    boolean check(int y, int x, String[] place){
        for(int i=0;i<4;i++){
            int ny = y+ next[i][0];
            int nx = x+ next[i][1];
            if(ny >=0 && ny<5 && nx>=0 && nx<5 && place[ny].charAt(nx) == 'P'){
                return false;
            }

            int nny = ny+ next[i][0];
            int nnx = nx+ next[i][1];

            if(nny >=0 && nny<5 && nnx>=0 && nnx<5 && place[nny].charAt(nnx) == 'P'){
                if(place[ny].charAt(nx) != 'X'){
                    return false;
                }
            }
        }

        for(int i=0;i<4;i++){
            int ny = y+ diag[i][0];
            int nx = x+ diag[i][1];
            if(ny >=0 && ny<5 && nx>=0 && nx<5 && place[ny].charAt(nx) == 'P'){
                if(place[ny-diag[i][0]].charAt(nx) != 'X' || place[ny].charAt(nx-diag[i][1]) != 'X'){
                    return false;
                }
            }
        }
        return true;
    }
}
// 최선이라고 말해줘2