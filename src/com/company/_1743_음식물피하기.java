package com.company;

import java.io.*;
import java.util.*;

public class _1743_음식물피하기 {
    static int R, C, N, ans, cc;
    static boolean[][] v;
    static int[][] map;

    static class Coords {
        int r;
        int c;

        public Coords(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        v = new boolean[R + 1][C + 1];
        ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (!v[i][j] && map[i][j] == 1) {
//                    bfs(i, j);
                    cc = 0;
                    v[i][j] = true;
                    dfs(i, j, 1);
                    ans = Math.max(ans, cc);

                }
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int i, int j, int cnt) {
        cc++;
        for (int d = 0; d < 4; d++) {
            int nr = dr[d] + i;
            int nc = dc[d] + j;

            if (nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
                if (!v[nr][nc] && map[nr][nc] == 1) {
                    v[nr][nc] = true;
                    dfs(nr, nc, cnt + 1);
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<Coords> q = new ArrayDeque<>();
        q.offer(new Coords(i, j));
        v[i][j] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Coords curr = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
                    if (!v[nr][nc] && map[nr][nc] == 1) {
                        q.offer(new Coords(nr, nc));
                        v[nr][nc] = true;
                    }
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}
