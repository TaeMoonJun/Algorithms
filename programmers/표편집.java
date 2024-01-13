import java.util.ArrayDeque;
import java.util.Deque;

class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        Row start = new Row(0, null);
        Row recent = start;
        Row now = start;

        for (int i = 1; i < n; i++) {
            Row row = new Row(i, recent);
            recent.next = row;
            recent = row;

            if (i == k) {
                now = recent;
            }
        }

        Deque<Row> stack = new ArrayDeque<>();
        for (String command : cmd) {
            if (command.equals("C")) {
//                System.out.println(now.num);
                now.present = false;
                stack.addLast(now);
                Row prev = now.prev;
                Row next = now.next;

                if (prev != null) {
                    prev.next = next;
                }

                if (next != null) {
                    next.prev = prev;
                    now = next;
                } else {
                    now = prev;
                }

            } else if (command.equals("Z")) {
                Row undo = stack.pollLast();
                Row prev = undo.prev;
                Row next = undo.next;
                undo.present = true;

                if (prev != null) {
                    prev.next = undo;
                }
                if (next != null) {
                    next.prev = undo;
                }

            } else {
                int x = Integer.parseInt(command.substring(2));
                if (command.charAt(0)=='U') {
                    while (x-- > 0) {
                        now = now.prev;
                    }
                } else {
                    while (x-- > 0) {
                        now = now.next;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = 0;
        while (start != null) {
            while (x++ < start.num) {
                sb.append("X");
            }
            if (start.present) {
                sb.append("O");
            } else {
                sb.append("X");
            }
            start = start.next;
        }
        for (int i = sb.length(); i < n; i++) {
            sb.append("X");
        }

        return sb.toString();
    }
}
//

class Row{
    int num;
    boolean present = true;
    Row next = null;
    Row prev;

    public Row(int num, Row prev) {
        this.num = num;
        this.prev = prev;
    }
}

//11/27 첫시도
//효율성 안될걸 예상하며 ArrayList에 스택이용해서 정해진 위치에 넣다 뺐다
//(이것 마저도 LinkedList가 낫지 않았을까)
//이후 해설 봤었음
//
//next와 prev가 있는 linked Node를 만들어서
//삭제시엔 앞뒤의 노드를 붙여주고 삭제한 노드는 스택에 넣는다
//
//bool안 쓰고 하려했는데 start에 대해서 처리하는게 귀찮아보여서 넣었음