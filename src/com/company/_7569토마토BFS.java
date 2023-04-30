package com.company;

import java.io.*;
import java.util.*;

public class _7569토마토BFS {
    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int N, M, H, day;
    static int[] parent, plan;
    static int[][][] tomatoCase;
    static boolean[][][] v;
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static Queue<Node> q;
    static List<Node> list;
    static int zeroCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 토마토 케이스 가로
        N = Integer.parseInt(st.nextToken()); // 토마토 케이스 세로
        H = Integer.parseInt(st.nextToken()); // 토마토 케이스 높이

        tomatoCase = new int[H][N][M];
        v = new boolean[H][N][M];
        q = new ArrayDeque<>();
        day = -1;

        // tomatoCase 입력
        boolean isBadTomato = false;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    tomatoCase[h][i][j] = tmp;
                    if(tmp == 1) q.offer(new Node(i, j, h));

                    // 입력 받았을 때, 모든 토마토가 익어있는지 판단
                    if (!isBadTomato && tmp == 0) isBadTomato = true;
                }
            }
        }

        // 입력 받았을 때 모든 토마토가 익어있다면
        if (!isBadTomato) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
//            int qSize = q.size();
//            for (int qs = 1; qs <= qSize; qs++) {
                Node curr = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nr = curr.x + dx[d];
                    int nc = curr.y + dy[d];
                    int nz = curr.z + dz[d];

                    if (nz >= 0 && nz < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (tomatoCase[nz][nr][nc] == 0) {
                            q.offer(new Node(nr, nc, nz));
                            tomatoCase[nz][nr][nc] = tomatoCase[curr.z][curr.x][curr.y] +1;
                        }
                    }
//                }
            }
        }

        int zeroCnt = zeroTomatoSearch();
        if(zeroCnt == -1) return -1;
        else return zeroCnt;
    }

    private static int zeroTomatoSearch() {
        int ans = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tomatoCase[h][i][j] == 0) return -1;
                    ans = Math.max(ans, tomatoCase[h][i][j]);
                }
            }
        }
        return ans-1;
    }
}

