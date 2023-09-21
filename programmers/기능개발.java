import java.util.ArrayList;

//42586
class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int index=0, today = 0, yet = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();

        while(yet>0){
            for(int i=index;i<progresses.length;i++){
                progresses[i] += speeds[i];
                if(i==index && progresses[i] >=100){
                    index++;
                    today++;
                    yet--;
                }
            }
            if(today!=0){
                list.add(today);
                today=0;
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}