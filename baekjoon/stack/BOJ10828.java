import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택
public class BOJ10828{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str;
        ArrayStack as = new ArrayStack(10000);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if (str.equals("push")) {
                as.push(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")) {
                as.pop();
            } else if (str.equals("size")) {
                as.size();
            } else if (str.equals("empty")) {
                as.empty();
            } else if (str.equals("top")) {
                as.top();
            }
        }
    }
}

class ArrayStack {
    private int top;
    private int size;
    private int [] stack;

    public ArrayStack(int stackSize) {
        top = -1;
        size = 0;
        stack = new int[stackSize];
    }

    public void push(int a) {
        stack[++top] = a;
        size++;
    }

    public void pop() {
        if(size >= 1) {
            System.out.println(stack[top--]);
            size--;
        }
        else
            System.out.println("-1");
    }

    public void size() {
        System.out.println(size);
    }
    public void empty() {
        if(size == 0)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public void top() {
        if(size != 0)
            System.out.println(stack[top]);
        else
            System.out.println("-1");
    }
}
// ArrayStack 클래스 작성하여 사용
