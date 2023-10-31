//49994
class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][] garo = new boolean[10][11];
        boolean[][] sero = new boolean[11][10];

        int x = 5, y=5;

        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i) == 'U'){
                if(y > 9) continue;
                if(!sero[x][y]){
                    sero[x][y] = true;
                    answer++;
                }
                y++;
            } else if(dirs.charAt(i) == 'D'){
                if(y < 1) continue;
                if(!sero[x][y-1]){
                    sero[x][y-1] = true;
                    answer++;
                }
                y--;
            } else if(dirs.charAt(i) == 'R'){
                if(x > 9) continue;
                if(!garo[x][y]){
                    garo[x][y] = true;
                    answer++;
                }
                x++;
            } else{
                if(x < 1) continue;
                if(!garo[x-1][y]){
                    garo[x-1][y] = true;
                    answer++;
                }
                x--;
            }
        }

        return answer;
    }
}