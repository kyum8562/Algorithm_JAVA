import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] list;

    static class Node {
        char type;
        int node;
        int dist;

        public Node(char type, int node, int dist) {
            this.type = type;
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0); // 늑대(W) or 양(S)
            int b = Integer.parseInt(st.nextToken()); // a의 개체 수
            int c = Integer.parseInt(st.nextToken()); // 해당 i섬에는 c로 가는 다리가 있음

            list[c].add(new Node(a, i, b)); // 1에서 아래로 내려갈 것
        }

        System.out.println(dfs(new Node('X', 1, 0)));
    }

    private static long dfs(Node curr) {
        long sum = 0;
        for (Node next : list[curr.node]) {
            sum += dfs(next);
        }
        if (curr.type == 'S') return sum + curr.dist;
        else return (sum - curr.dist > 0) ? sum - curr.dist : 0;
    }
}