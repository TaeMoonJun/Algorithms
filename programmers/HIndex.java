import java.util.*;

//42747
class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h=0;
        for(;h<citations.length;){
            h++;
            int over=0;
            for(int i=0;i<citations.length;i++){
                if(h<=citations[i]){
                    over++;
                }
            }
            System.out.println(h);
            System.out.println(over);
            if(over<h){
                h--;
                break;
            }
        }

        return h;
    }
}