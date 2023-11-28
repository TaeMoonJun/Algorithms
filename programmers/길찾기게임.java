import java.util.*;

//42892
class 길찾기게임 {
    ArrayList<Integer> preAns;
    ArrayList<Integer> postAns;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        preAns = new ArrayList<>();
        postAns = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            return o2.y - o1.y;
        });

        Node root = nodes[0];
        for (int i=1;i<nodes.length;i++){
            Node curr = root;
            while (true) {
                if (nodes[i].x > curr.x) {
                    if (curr.right == null) {
                        curr.right = nodes[i];
                        break;
                    }
                    curr = curr.right;
                } else {
                    if (curr.left == null) {
                        curr.left = nodes[i];
                        break;
                    }
                    curr = curr.left;
                }
            }
        }

        pre(root);
        post(root);

        return new int[][]{preAns.stream().mapToInt(Integer::valueOf).toArray(),
                postAns.stream().mapToInt(Integer::valueOf).toArray()};
    }

    void pre(Node root){
        preAns.add(root.n);
        if (root.left != null) {
            pre(root.left);
        }
        if (root.right != null) {
            pre(root.right);
        }
    }

    void post(Node root) {
        if (root.left != null) {
            post(root.left);
        }
        if (root.right != null) {
            post(root.right);
        }
        postAns.add(root.n);
    }
}

class Node{
    int n;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
}
// 트리 레벨을 막 따지려고했는데 그럴 필요가 없었다
// 문제나 잘 읽자