//92335
class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0, pointer = 0;
        String binary = Integer.toString(n, k);

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != '0') {
                continue;
            }

            String temp = binary.substring(pointer, i);
            if (!(temp.equals(""))) {
                if ( isPrime(Long.parseLong(temp))) {
                    answer++;
                }
            }

            pointer = i + 1;
        }
        if (!(binary.substring(pointer).equals(""))) {
            if (isPrime(Long.parseLong(binary.substring(pointer)))) {
                answer++;
            }
        }

        return answer;
    }


    boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// 문제를 대충읽음 (단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.)
// ""은 if문으로 방지했어야함