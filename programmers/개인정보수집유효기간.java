import java.util.*;

//150370
class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new LinkedList<>();
        Map<String,Integer> termMap = new HashMap<>();

        for(int i=0;i<terms.length;i++){
            String[] t = terms[i].split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        for(int i=0;i<privacies.length;i++){
            String[] p = privacies[i].split(" ");
            String[] date = p[0].split("\\.");
            int[] deadline = Arrays.stream(date).mapToInt(Integer::parseInt).toArray();

            int offset0 = termMap.get(p[1])/12;
            int offset1 = termMap.get(p[1])%12;
            deadline[0]+= offset0;
            deadline[1]+= offset1;
            deadline[2]--;

            if(deadline[2] ==0){
                deadline[2] = 28;
                deadline[1]--;
                if(deadline[1] ==0){
                    deadline[1] = 12;
                    deadline[0]--;
                }
            }
            if(deadline[1] > 12){
                deadline[0]++;
                deadline[1] -= 12;
            }

            String[] now = today.split("\\.");
            for(int j=0;j<3;j++){
                if(deadline[j] < Integer.parseInt(now[j])){
                    list.add(i+1);
                    break;
                } else if (deadline[j] > Integer.parseInt(now[j])){
                    break;
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// 년*12*28 + 월*28 + 일로 비교하는 방법이 있었음...
// 주먹구구식 조건문...