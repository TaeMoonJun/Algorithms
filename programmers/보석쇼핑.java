import java.util.*;

//67258
class 보석쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String,Integer> countMap = new HashMap<>();
        int start =0, min=gems.length;
        int[] answer = new int[]{};

        for(int i=0;i<gems.length;i++){
            if(countMap.keySet().contains(gems[i])){
                countMap.put(gems[i], countMap.get(gems[i])+1);
            } else{
                countMap.put(gems[i], 1);
            }

            if(countMap.size() == set.size()){
                while(countMap.get(gems[start])>1){
                    countMap.put(gems[start], countMap.get(gems[start])-1);
                    start++;
                }
                if(min > i-start){
                    min = i-start;
                    answer = new int[]{start+1,i+1};
                }
            }
        }

        return answer;
    }
}

// 처음에 풀려고 한 방식 n이랑 효율성 테스트 보고 O(n)에 가깝게 풀어보려한거랑 start랑 map을 사용한 접근은 맞는데
// 투포인터랑 map에 뭘 저장할까(count)를 생각 못한 죄
