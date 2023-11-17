import java.util.HashSet;

//42839
class 소수찾기 {
    public int solution(String numbers) {
        boolean[] aristo = new boolean[(int)Math.pow(10,numbers.length())];
        aristo[0] = true;
        aristo[1] = true;
        char[] numSep = new char[numbers.length()];
        boolean[] checked = new boolean[numbers.length()];
        HashSet<Integer> set = new HashSet<>();
        int count=0;

        for(int i=2;i<=Math.sqrt(aristo.length);i++){
            if(aristo[i]){
                continue;
            }
            int target = i;
            for(int j=i;;j++){
                target = i*j;
                if(target >= aristo.length){
                    break;
                }
                aristo[target] = true;
            }
        }

        for(int i=0;i<numbers.length();i++){
            numSep[i] = numbers.charAt(i);
        }

        dfs(aristo, numSep, checked, "", set);

        for(Integer i: set){
            if(!aristo[i]){
                count++;
            }
        }

        return count;
    }

    void dfs(boolean[] aristo, char[] numSep, boolean[] checked, String str, HashSet<Integer> set){
        for(int i=0;i<numSep.length;i++){
            if(!checked[i]){
                String nStr = str+String.valueOf(numSep[i]);
                int number = Integer.parseInt(nStr);
                set.add(number);

                checked[i] = true;
                dfs(aristo, numSep, checked, nStr, set);
                checked[i] = false;
            }
        }
    }
}