//49993
class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int imp=0;

        for(String s: skill_trees){
            int req = -1;
            boolean noMore = false;
            for(int i=0;i<skill.length();i++){
                int n = s.indexOf(skill.charAt(i));
                if(n == -1){
                    noMore = true;
                } else if(noMore){
                    imp++;
                    break;
                } else if(n <= req){
                    imp++;
                    break;
                }
                req=n;
            }
        }

        return skill_trees.length -imp;
    }
}