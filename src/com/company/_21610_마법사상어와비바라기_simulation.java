package com.company;

import java.io.*;
import java.util.*;

public class _21610_마법사상어와비바라기_simulation {
    static int N, M;
    static int[][] map;
    static Queue<Node> clouds;
    static boolean[][] v;

    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /**
     * 0. 초기 구름 설정
     * 1. [턴] 모든 구름 d 방향으로 s 만큼 이동( ArrayList에 넣고 이동)
     * 2. 구름 있는 칸에 +1 씩
     * 3. (isVaild 하는) 대각선 방향에 물있다면, 물있는칸만큼 구름칸에 더해줌
     * 4. 구름 다 사라짐
     * 5. [구름 사라지지 않은 칸들 중]
     * 바구니에 저장된 물의 양 2 이상인 모든 칸에 구름 생성 및 물의 양 -2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        clouds = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 설정
        clouds.offer(new Node(N - 2, 0));
        clouds.offer(new Node(N - 2, 1));
        clouds.offer(new Node(N-1, 0));
        clouds.offer(new Node(N-1, 1));

        // 턴 시작
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            v = new boolean[N][N];

            // step12: 구름 이동 + 구름 칸 물의 양 1 증가
            step12(d, s);
            // step34: 구름 사라지게 하기 + 대각선 바구니의 물이 들어있는지 확인하고 카운트 업
            step34();
            // step5: 구름 없는 칸`들 중 물이 2이상이면 구름 생성 및 물의양 2 줄이기
            step5();
        }
            // step6: 모든 바구니 sum
            int ans = step6();

            System.out.println(ans);
    }

    private static int step6() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void step5() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!v[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.offer(new Node(i, j));
                }
            }
        }
    }

    private static void step34() {
        while (!clouds.isEmpty()) {
            Node cloud = clouds.poll();
            int waterCnt = 0;

            v[cloud.r][cloud.c] = true;
            for (int d = 1; d <= 7; d += 2) {
                int nr = cloud.r + dr[d];
                int nc = cloud.c + dc[d];

                if (isValid(nr, nc) && map[nr][nc] > 0) waterCnt++;
            }

            map[cloud.r][cloud.c] += waterCnt;
        }
    }

    private static void step12(int d, int s) {
        for (Node cloud : clouds) {
            cloud.r = (N + cloud.r + dr[d] * (s % N)) % N;
            cloud.c = (N + cloud.c + dc[d] * (s % N)) % N;
                map[cloud.r][cloud.c]++;
        }
    }

    private static boolean isValid(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }

}
