import java.util.*;

//81301
class 숫자문자열과영단어 {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int idx = -1;

        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) > '9'){
                if(idx == -1){
                    idx = i;
                }else if(map.keySet().contains(s.substring(idx, i+1))){
                    sb.append(map.get(s.substring(idx,i+1)));
                    idx = -1;
                }
            } else{
                sb.append(s.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
// 최선이라고 말해