import java.util.*;

class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        String[] lang = new String[]{"java", "python", "cpp", "-"};
        String[] job = new String[]{"backend", "frontend", "-"};
        String[] exp = new String[]{"junior", "senior", "-"};
        String[] food = new String[]{"pizza", "chicken", "-"};

        for (String str : info) {
            String[] row = str.split(" ");

            for (int i = 0; i < lang.length; i++) {
                if (!lang[i].equals("-") && !lang[i].equals(row[0])) {
                    continue;
                }
                for (int j = 0; j < job.length; j++) {
                    if (!job[j].equals("-") && !job[j].equals(row[1])) {
                        continue;
                    }
                    for (int k = 0; k < exp.length; k++) {
                        if (!exp[k].equals("-") && !exp[k].equals(row[2])) {
                            continue;
                        }
                        for (int l = 0; l < food.length; l++) {
                            if (!food[l].equals("-") && !food[l].equals(row[3])) {
                                continue;
                            }
                            String key = lang[i] + job[j] + exp[k] + food[l];

                            if (!map.containsKey(key)) {
                                map.put(key, new ArrayList<>());
                            }
                            map.get(key).add(Integer.parseInt(row[4]));
                        }
                    }
                }
            }
        }
        for (String str : map.keySet()) {
            map.get(str).sort(Comparator.naturalOrder());
        }

        for (int i=0;i< query.length;i++) {
            String[] row = query[i].split(" ");
            String key = row[0] + row[2] + row[4] + row[6];
            int n = Integer.parseInt(row[7]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
            } else {
                List<Integer> list = map.get(key);
                answer[i] = binarySearch(list, n);
            }
        }
        
        return answer;
    }

    int binarySearch(List<Integer> list, int n) {
        int top = list.size()-1;
        int bottom = 0;

        while (top >= bottom) {
            int mid = (top + bottom) / 2;
            if (list.get(mid) >= n) {
                top = mid-1;
            } else {
                bottom = mid+1;
            }
        }
//        System.out.println(bottom+" "+top);
        return list.size() - bottom;
    }
}

//언어	cpp, java, python
//직군	backend, frontend
//경력	junior, senior
//음식	chicken, pizza
//점수	1~100000
//
//info	1~50000
//query	1~100000
//
//java and backend and junior and pizza 100
//
//각 쿼리 결과가 몇명인지 return
//1. 점수는 이분탐색으로 갑시다!
//이분탐색	log(n)
//
//점수 제외 모든 가지수 24
//24개 모두 나눠서 저장해놓고??
//      !!!!!!!!!!!!나누지 않았으면 됐음!!!!!!!!
//가능한 query string을 모두 넣어서 Map에 점수 저장

//런타임에러 두번 뜸
//1. binarySearch top에서 -1 안해줌 ㅋㅋ
//2. map에 query로 get할때 key 없으면 따로 0으로 처리