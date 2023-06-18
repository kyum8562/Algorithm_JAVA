package com.company;

import java.io.*;
import java.util.*;

public class _16946_벽부수고이동하기4 {
    static int N, M;
    static int[][] map, ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, Integer> hm = new HashMap<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 그룹화하기
        int index = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    hm.put(index, bfs(i, j, index++));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapCount(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void mapCount(int x, int y) {
        if (map[x][y] == 1) {

            ans[x][y] = 1;

            Set<Integer> hs = new HashSet<>();

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + x;
                int ny = dy[d] + y;

                if (!isSquare(nx, ny) || map[nx][ny] == 1) continue;

                hs.add(map[nx][ny]);
            }

            for (int a : hs) ans[x][y] += hm.get(a);
        }

    }

    private static int bfs(int x, int y, int groupNum) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        map[x][y] = groupNum;
        int count = 1;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + curr.x;
                int ny = dy[d] + curr.y;

                if (isSquare(nx, ny) && map[nx][ny] == 0 && map[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    map[nx][ny] = groupNum;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isSquare(int nx, int ny) {
        return (nx >= 0 && nx < N && ny >= 0 && ny < M);
    }
}
