package com.company;

import java.util.*;
import java.io.*;

public class prog_게임맵최단거리 {
    static int N, M, ans;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

    public static void main(String[] args) throws IOException {

        ans = -1;
        map = maps;
        N = map.length;
        M = map[0].length;
        v = new boolean[N][M];
        v[0][0] = true;

        boolean flag = false;
        for (int d = 0; d < 4; d++) {
            int nr = N - 1 + dr[d];
            int nc = M - 1 + dc[d];

            if (map[nr][nc] == 1) {
                flag = true;
                break;
            }

        }
        if (flag) {
//            DFS(0, 0, 1);
            BFS(0, 0);
        }
        else
            System.out.println(-1);

        System.out.println(ans);
    }

    private static void BFS(int r, int c) {
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 1});

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            r = tmp[0];
            c = tmp[1];
            int cnt = tmp[2];

            if(r == N -1 && c == M -1){
                ans = cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1 && !v[nr][nc]) {
                        v[nr][nc] = true;
                        q.offer(new int[]{nr, nc, cnt+1});
                    }
                }
            }
        }
    }

    public static void DFS(int r, int c, int sum) {
        if (r == N - 1 && c == M - 1) {
            if (ans > sum) ans = sum;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] == 1 && !v[nr][nc]) {
                    v[nr][nc] = true;
                    DFS(nr, nc, sum + 1);
                    v[nr][nc] = false;
                }
            }
        }
    }
}
