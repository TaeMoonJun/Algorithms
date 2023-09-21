import java.util.*;

//42578
class 의상 {
    public int solution(String[][] clothes) {
        int answer=1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String where = clothes[i][1];
            if(map.containsKey(where)){
                int num = map.get(where);
                map.put(where, num+1);
            } else{
                map.put(where, 1);
            }
        }
        int[] choice = new int[map.size()];
        int index = 0;
        for(String s:map.keySet()){
            choice[index] = map.get(s);
            index++;
        }

        for(int i=0;i<choice.length;i++){
            answer *= choice[i]+1;
        }

        return answer-1;
    }
}