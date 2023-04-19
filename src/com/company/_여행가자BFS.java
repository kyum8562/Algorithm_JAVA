package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _여행가자BFS {
    static int N, M;
    static int[] parent, plan;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 수
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 여행 계획에 속한 도시들의 수
        parent = new int[N + 1];
        plan = new int[N + 1];
        map = new int[N + 1][N + 1];

        // map 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++)
            plan[i] = Integer.parseInt(st.nextToken());

        boolean flag = true;
        for (int i = 1; i < N; i++) {
            if (map[plan[i]][plan[i + 1]] == 0) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

}
