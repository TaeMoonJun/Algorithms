import java.util.*;

//64065
class 튜플 {
    public int[] solution(String s) {
        s = s.substring(1,s.length()-1);
        int start=0;
        List<String> setList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '{'){
                start = i;
            } else if(s.charAt(i) == '}'){
                setList.add(s.substring(start, i+1));
            }
        }

        setList.sort((o1, o2)->{
            return o1.length()-o2.length();
        });

        for(String string: setList){
            String[] numbers = string.substring(1, string.length()-1).split(",");
            for(String n: numbers){
                int i = Integer.parseInt(n);
                if(!numSet.contains(i)){
                    numSet.add(i);
                    list.add(i);
                    break;
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 성능 때문에 contains 사용할 Set을 추가로 만들었는데
// 성능 테스트를 안하네;;