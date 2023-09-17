//12909
class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        int stack =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack++;
            } else{
                if (stack <1){
                    answer = false;
                    break;
                } else{
                    stack--;
                }
            }
        }
        if (stack >0){
            answer = false;
        }
        
        return answer;
    }
}
// 원래는 스택