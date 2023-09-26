import java.util.*;

//92334
class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일 받는 횟수
        Map<String, Integer> indexMap = new HashMap<>(); // 이용자 번호
        List<Set<String>> reportBy = new ArrayList<>(); // 누구에게
        // 당함,함 -> 정지된 사람 알기 좋음
        // 함,당함 -> 메일 보내기 쉬움

        for(int i=0;i<id_list.length;i++){ // 이용자 번호 저장하고 list init
            indexMap.put(id_list[i], i);
            reportBy.add(new HashSet<String>());
        }

        for(int i=0;i<report.length;i++){ // 누구에게 신고당했는지
            String[] r = report[i].split(" ");
            int index = indexMap.get(r[1]);
            Set<String> set = reportBy.get(index);
            if(!set.contains(r[0])){
                set.add(r[0]);
            }
        }

        for(int i=0;i<id_list.length;i++){
            Set<String> set = reportBy.get(i);
            if(set.size()>=k){
                for(String s:set.toArray(String[]::new)){
                    answer[indexMap.get(s)]++;
                }
            }
        }

        return answer;
    }
}