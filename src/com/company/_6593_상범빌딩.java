package com.company;

import java.io.*;
import java.util.*;

public class _6593_상범빌딩 {
    static int L, R, C, startX, startY, startF, endX, endY, endF, ans;
    static char[][] map;
    static boolean[][][] v;
    static Queue<Coords> q;
    static List<char[][]> floor;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    static class Coords {
        int r;
        int c;
        int f;

        public Coords(int r, int c, int f) {
            this.r = r;
            this.c = c;
            this.f = f;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 입력 종료 조건
            if (L == 0) break;

            // 초기화
            floor = new ArrayList<>();
            v = new boolean[L][R][C];
            startX = startY = startF = endX = endY = endF = ans = 0;

            // 층 만큼
            for (int i = 0; i < L; i++) {
                map = new char[R][C];
                for (int j = 0; j < R; j++) {
                    String tmp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char tgt = tmp.charAt(k);
                        map[j][k] = tgt;

                        // 시작, 종료값 얻음
                        if (tgt == 'S') {
                            startF = i;
                            startX = j;
                            startY = k;
                        }
                        if (tgt == 'E') {
                            endF = i;
                            endX = j;
                            endY = k;
                        }
                    }
                }
                floor.add(map);
                String tmp = br.readLine(); // 공백
            }

            int ans2 = bfs(startX, startY, startF);

            System.out.println(ans2 == -1 ? "Trapped!" : "Escaped in " + ans2 + " minute(s).");
        }
    }

    private static int bfs(int startX, int startY, int startF) {
        q = new ArrayDeque<>();
        v[startF][startX][startY] = true;
        q.offer(new Coords(startX, startY, startF));

        int sum = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();

            sum++;

            for (int i = 0; i < qSize; i++) {
                Coords curr = q.poll();

                // 종료 조건
                if(curr.r == endX && curr.c == endY && curr.f == endF) return sum;

                for(int d = 0 ; d < 6 ; d ++){
                    int nr = dr[d] + curr.r;
                    int nc = dc[d] + curr.c;
                    int nf = curr.f;
                    // d가 4이면 '상', d가 5이면 '하'
                    if(d == 4) nf += 1;
                    if(d == 5) nf += -1;

                    // 박스 안 조건
                    if(nr >= 0 && nr < R && nc >= 0 && nc < C && nf >= 0 && nf < L){
                        // 이동 조건
                        if(floor.get(nf)[nr][nc] != '#' && !v[nf][nr][nc]){
                            q.offer(new Coords(nr, nc, nf));
                            v[nf][nr][nc] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}























