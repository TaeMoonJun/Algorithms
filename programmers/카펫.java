//42842
class 카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for(int i=3;i<sum/3+1;i++){
            if(i*(sum/i) == sum){
                int x = sum/i;
                for(int j=1;j<x;j++){
                    if(j*(yellow/j)== yellow && (yellow/j)<x && j<i-1){
                        System.out.println(yellow/j);
                        return new int[] {x, i};
                    }
                }
            }
        }

        return null;
    }
}