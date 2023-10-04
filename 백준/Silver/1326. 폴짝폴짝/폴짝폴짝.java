import java.io.*;
import java.util.*;

public class Main {
    static int N, s, e, res = Integer.MAX_VALUE;
    static int[] map;
    static boolean[] v;
    static int[] delta = {-1, 1};

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        map = new int[N + 1];
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();

        v = new boolean[N + 1];
        v[s] = true;
        q.offer(new Node(s, 0));

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int curr = currNode.node;

            if (curr == e) {
                res = Math.min(res, currNode.dist);
                return;
            }

            int tmp = map[curr];
            for (int i = tmp; i <= N; i += tmp) {
                for (int d = 0; d < 2; d++) {
                    int next = curr + (delta[d] * i);

                    if (next < 1 || next > N) continue;
                    if (v[next]) continue;
                    v[next] = true;
                    q.offer(new Node(next, currNode.dist + 1));
                }
            }
        }

    }
}