import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] v;

    static class Node {
        int r;
        int c;
        int d;
        boolean isGet;

        Node(int r, int c, int d, boolean isGet) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.isGet = isGet;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0);
    }

    private static void bfs(int sr, int sc) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc, 0, false));
        v[sr][sc][0] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.d > T) break;
            if (curr.r == N - 1 && curr.c == M - 1) {
                ans = curr.d;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (!isValid(nr, nc)) continue;

                if (!curr.isGet) {
                    // 빈 공간 만남
                    if (map[nr][nc] == 0 && !v[nr][nc][0]) {
                        q.offer(new Node(nr, nc, curr.d + 1, curr.isGet));
                        v[nr][nc][0] = true;
                    }
                    // 검 만남
                    else if (map[nr][nc] == 2 && !v[nr][nc][1]) {
                        q.offer(new Node(nr, nc, curr.d + 1, true));
                        v[nr][nc][0] = true;
                    }
                } else {
                    // 검 있음
                    if (!v[nr][nc][1]) {
                        q.offer(new Node(nr, nc, curr.d + 1, curr.isGet));
                        v[nr][nc][1] = true;
                    }
                }

            }
        }

        if (ans <= T) System.out.println(ans);
        else System.out.println("Fail");
    }


    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}