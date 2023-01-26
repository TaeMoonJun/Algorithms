import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 큐 2
public class BOJ18258{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str;
        ArrayQueue aq = new ArrayQueue(2000000);


        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            switch (str[0]){
                case "push": aq.push(Integer.parseInt(str[1]));
                    break;
                case "pop": aq.pop();
                    break;
                case "size": aq.size();
                    break;
                case "empty": aq.empty();
                    break;
                case "front": aq.front();
                    break;
                case "back": aq.back();
                    break;
            }
        }
        System.out.println(sb);
    }

    static class ArrayQueue {
        private int front;
        private int back;
        private int size;
        private int [] queue;

        public ArrayQueue(int queueSize) {
            front = back = -1;
            size = 0;
            queue = new int[queueSize];
        }

        public void push(int a) {
            queue[++back] = a;
            size++;
        }

        public void pop() {
            if(size >= 1) {
                sb.append(queue[++front]).append("\n");
                size--;
            } else
                sb.append("-1\n");
        }

        public void size() {
            sb.append(size).append("\n");
        }

        public void empty() {
            if(size == 0)
                sb.append("1").append("\n");
            else
                sb.append("0").append("\n");
        }

        public void front() {
            if(size != 0)
                sb.append(queue[front+1]).append("\n");
            else
                sb.append("-1\n");
        }

        public void back() {
            if(size != 0)
                sb.append(queue[back]).append("\n");
            else
                sb.append("-1\n");
        }
    }
}
// ArrayQueue 클래스 작성하여 사용
