package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _그림BFS {
    static class node {
        int r, c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, cnt, ans;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Queue<node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    BFS(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }

    private static void DFS(int j, int k) {
        visited[j][k] = true;

        for (int d = 0; d < 4; d++) {
            int nr = dr[d] + j;
            int nc = dc[d] + k;

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (!visited[nr][nc] && arr[nr][nc] == 1)
                    DFS(nr, nc);
            }
        }
    }

    private static void BFS(int i, int j) {
        int smallAns = 0;

        q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new node(i, j));

        while (!q.isEmpty()) {
            node curr = q.poll();
            smallAns++;

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc] && arr[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.offer(new node(nr, nc));
                    }
                }
            }
        }
        if(smallAns > ans) ans = smallAns;
    }
}


