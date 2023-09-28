//118666
class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] type = {"RT", "CF","JM","AN"};
        int[] result = new int[4];

        for(int i=0;i<survey.length;i++){
            for(int j=0;j<4;j++){
                if(type[j].charAt(0) == survey[i].charAt(0)){
                    result[j] += choices[i]-4;
                    break;
                } else if (type[j].charAt(1) == survey[i].charAt(0)){
                    result[j] -= choices[i]-4;
                    break;
                }
            }
        }

        for(int i=0;i<4;i++){
            if(result[i]<=0){
                answer += type[i].charAt(0);
            } else answer += type[i].charAt(1);
        }

        return answer;
    }
}