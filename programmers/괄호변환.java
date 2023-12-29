//60058
class 괄호변환 {
    public String solution(String p) {
        String answer = toRight(p);

        return answer;
    }

    String toRight(String str) {
        if (isRight(str)) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        String[] uv = split(str);

        if (isRight(uv[0])) {
            sb.append(uv[0]).append(toRight(uv[1]));
            return sb.toString();
        } else {
            sb.append('(').append(toRight(uv[1])).append(')');
            sb.append(forU(uv[0]));
        }
        return sb.toString();
    }

    boolean isRight(String str) {
        int stack = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                stack--;
                if (stack < 0) {
                    return false;
                }
            } else {
                stack++;
            }
        }

        return true;
    }

    String[] split(String str) {
        int stack = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                stack--;
            } else {
                stack++;
            }

            if (stack == 0) {
                return new String[]{str.substring(0, i + 1), str.substring(i+1)};
            }
        }
        return new String[]{str, ""};
    }

    String forU(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length() - 1);
        sb.deleteCharAt(0);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb2.append(')');
            } else {
                sb2.append('(');
            }
        }
        return sb2.toString();
    }
}
//그냥 하라는대로 했는데 문제이해가 어렵긴해