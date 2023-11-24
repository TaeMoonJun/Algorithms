//67256
class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};

        for(int i=0;i<numbers.length;i++){
            int[] coordi = new int[]{(numbers[i]-1)/3, (numbers[i]-1)%3};
            if(numbers[i] == 0){
                coordi= new int[]{3,1};
            }

            if(coordi[1] == 0){
                left = coordi;
                sb.append("L");
            }else if(coordi[1] == 2){
                right = coordi;
                sb.append("R");
            }else{
                int l = Math.abs(coordi[0]-left[0]) + Math.abs(coordi[1]-left[1]);
                int r = Math.abs(coordi[0]-right[0]) + Math.abs(coordi[1]-right[1]);
                if((l > r) || (l==r && hand.equals("right"))){
                    right = coordi;
                    sb.append("R");
                }else{
                    left = coordi;
                    sb.append("L");
                }
            }
        }

        return sb.toString();
    }
}