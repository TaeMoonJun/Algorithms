import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭발
public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String string = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.add(string.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean yes = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
// String + Stack