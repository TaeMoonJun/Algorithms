import java.util.*;

//64061
class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] pointer = new int[board.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<board.length;i++){
            for(int j=board.length-1;j>=0;j--){
                if(board[j][i] != 0){
                    pointer[i] = j;
                } else{
                    break;
                }
            }
        }

        for(int i=0;i<moves.length;i++){
            int line = moves[i] -1;
            if(pointer[line] >= board.length){
                continue;
            }
            int picked = board[pointer[line]][line];
            pointer[line]++;

            if(deque.isEmpty()){
                deque.addLast(picked);
            }else{
                if(deque.peekLast() == picked){
                    deque.removeLast();
                    answer+=2;
                } else{
                    deque.addLast(picked);
                }
            }
        }

        return answer;
    }
}