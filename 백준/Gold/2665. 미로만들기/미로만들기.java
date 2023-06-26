import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M;
    static char[][] map;
    static int[][] v;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        v = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(v[i], INF);
        }

        v[0][0] = 0;
        q.offer(new Node(0, 0));

        bfs();

        System.out.println(v[N-1][N-1]);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (!isValid(nr, nc)) continue;

                if (map[nr][nc] == '1') {
                    if (v[nr][nc] > v[curr.r][curr.c]) {
                        v[nr][nc] = v[curr.r][curr.c];
                        q.offer(new Node(nr, nc));
                    }
                } else {
                    if (v[nr][nc] > v[curr.r][curr.c] + 1) {
                        v[nr][nc] = v[curr.r][curr.c] + 1;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }

}