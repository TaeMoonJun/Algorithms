//12904
class 가장긴팰린드롬{
    public int solution(String s) {
        int answer = 1;

        for (int i = 1; i < s.length(); i++) {
            int a = isPal(s, i);
            int b = isPal2(s, i);
//            System.out.println(a+" "+b);
            if (a > answer || b > answer) {
                answer = Math.max(a, b);
            }
        }

        return answer;
    }

    int isPal(String s, int index) {
        int i = 1;
        while (index + i < s.length() && index - i >= 0) {
            if (s.charAt(index + i) != s.charAt(index - i)) {
                return (i - 1)*2+1;
            }
            i++;
        }
        return (i - 1)*2+1;
    }

    int isPal2(String s, int index) {
        int i = 0;
        while (index + i < s.length() && index - i -1 >= 0) {
            if (s.charAt(index + i) != s.charAt(index - i - 1)) {
                return i * 2;
            }
            i++;
        }
        return i*2;
    }
}
// aba 말고 aa 같이 짝수길이로 똑같은것도