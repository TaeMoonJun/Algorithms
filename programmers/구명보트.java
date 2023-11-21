import java.util.Arrays;

//42885
//Greedy? Two Pointer?
class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0, front =0, rear= people.length-1;
        Arrays.sort(people);

        while(front<=rear){
            if(front == rear){
                answer++;
                break;
            }
            if(people[front]+people[rear] > limit){
                rear--;
                answer++;
            }else{
                rear--;
                front++;
                answer++;
            }
        }
        return answer;
    }
}