import java.util.*;

//42583
class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, index =0;
        Deque<Integer[]> stack = new LinkedList<>();
        stack.push(new Integer[]{0,0});
        while(index<truck_weights.length){
            if(stack.size() !=0 && stack.peek()[1] <= time){
                Integer[] out = stack.pop();
                weight += out[0];
            }
            if(weight - truck_weights[index]>=0){
                stack.add(new Integer[]{truck_weights[index], time+bridge_length});
                weight -= truck_weights[index];
                index++;
            }
            time++;
        }
        
        return stack.pollLast()[1]+1;
    }
}