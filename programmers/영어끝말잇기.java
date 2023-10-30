import java.util.*;

//12981
class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char last = words[0].charAt(0);

        for(int i=0;i<words.length;i++){
            if(last != words[i].charAt(0)){
                return new int[] {i%n+1, i/n+1};
            } else if(set.contains(words[i])){
                return new int[] {i%n+1, i/n+1};
            }
            last = words[i].charAt(words[i].length() -1);
            set.add(words[i]);
        }

        return new int[] {0,0};
    }
}