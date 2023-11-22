import java.util.*;

//64064
class 불량사용자 {
    List<Set<String>> banCandidate = new ArrayList<>();
    Set<Set<String>> caseSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        for(int i=0;i<banned_id.length;i++){
            Set<String> set = new HashSet<>();

            for(int j=0;j<user_id.length;j++){
                String user = user_id[j];
                if(user.length() != banned_id[i].length()){
                    continue;
                }
                for(int k=0;k<user.length();k++){
                    if(banned_id[i].charAt(k) == '*' || banned_id[i].charAt(k) == user.charAt(k)){
                        if(k==user.length()-1){
                            set.add(user);
                        }
                    } else{
                        break;
                    }
                }
            }
            banCandidate.add(set);
        }

        dfs(new HashSet<String>(), 0);

        return caseSet.size();
    }

    void dfs(Set<String> banState, int count){
        if(count == banCandidate.size()){
            caseSet.add(new HashSet<String>(banState));
            return;
        }

        Set<String> candidate = banCandidate.get(count);
        for(String s: candidate){
            if(!banState.contains(s)){
                banState.add(s);

                dfs(banState, count+1);

                banState.remove(s);
            }
        }
    }
}

// 테케 2문제가 안됐음 틀린거, 시간초과
// 틀린거는 caseSet에 add시에 얕은 복사 문제
// 시간초과는 처음 해결했을때는 pruning을 안한게 문제인 줄 알았으나
// 문제 조건을 다시 생각하니 visited를 사용할 필요없이 모두 매칭을 하기만 하면 됐음