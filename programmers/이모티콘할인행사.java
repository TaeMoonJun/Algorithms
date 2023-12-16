//150368
class 이모티콘할인행사 {
    static int[] discount = new int[]{10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0,0};
        int[] promotion = new int[emoticons.length];

        dfs(users, emoticons, promotion, answer, 0);

        return answer;
    }

    void dfs(int[][] users, int[] emoticons, int[] promotion, int[] answer, int depth){
        if (depth == emoticons.length) {
            int[] result = new int[users.length];
            int subs = 0, sum = 0;

            for (int u = 0; u < users.length; u++) {
                for (int e = 0; e < emoticons.length; e++) {
                    if (promotion[e] >= users[u][0]) {
                        result[u] += emoticons[e]*(1-(float)promotion[e]/100);
                    }
                }
            }

            for (int u = 0; u < users.length; u++) {
                if (result[u] >= users[u][1]) {
                    subs++;
                } else {
                    sum += result[u];
                }
            }
            if (subs > answer[0]) {
                answer[0] = subs;
                answer[1] = sum;
            } else if (subs == answer[0] && sum > answer[1]) {
                answer[1] = sum;
            }
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            promotion[depth] = discount[i];
            dfs(users, emoticons, promotion, answer, depth+1);
        }

    }
}

//    n	사용자		100
//    m	이모티콘		7
//    할인률	10 20 30 40     4
//
//    특정 할인률 이상의 이모티콘을 모두 구매하거나 서비스 가입
//    가입자 최대 -> 판매액 최대
//
//    100*4^7 완탐