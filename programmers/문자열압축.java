//60057
class 문자열압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length() / 2; i++) {
            int length = 0;

            for (int j = 0; j+i < s.length();) {
                int index = j;
                String target = s.substring(j, j + i);

                while (true) {
                    j += i;
                    if (j+i > s.length() || !s.substring(j, j + i).equals(target)) {
                        break;
                    }
                }
                if (j - index == i) {
                    length += i;
                } else {
                    length += i + String.valueOf((j-index)/i).length();
                }

                if (j + i >= s.length()) {
                    length += s.length() - j;
                }
            }
            answer = Math.min(answer, length);
        }

        return Math.min(answer, s.length());
    }
}
// 왤케 오래걸렸어 너 다시풀어