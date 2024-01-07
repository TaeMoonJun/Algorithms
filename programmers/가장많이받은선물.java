import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameMap = new HashMap<>();
        int[][] giftGraph = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        int[] result = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            nameMap.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int gave = nameMap.get(names[0]);
            int got = nameMap.get(names[1]);

            giftGraph[gave][got]++;
            giftIndex[gave]--;
            giftIndex[got]++;
        }

        for (int i = 0; i < giftGraph.length; i++) {
            for (int j = i; j < giftGraph.length; j++) {
                if (giftGraph[i][j] > giftGraph[j][i]) {
                    result[i]++;
                } else if (giftGraph[i][j] < giftGraph[j][i]) {
                    result[j]++;
                } else if (giftIndex[i] < giftIndex[j]) {
                    result[i]++;
                } else if (giftIndex[i] > giftIndex[j]) {
                    result[j]++;
                }
            }
        }

        return Arrays.stream(result).max().getAsInt();
    }

}

//선물 많이 준 사람이 선물 받음
//	기록 없거나 같다면 선물 지수 큰 사람이 선물 받음
//		선물 지수도 같으면 땡처리
//
//선물지수	준선물 - 받은 선물
//
//가장 선물 많이 받을 사람의 받을 선물개수 return
//
//friends	2~50
//gifts	1~10000 "누가 누구에게"