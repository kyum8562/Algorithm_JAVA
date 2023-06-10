package com.company;

import java.io.*;
import java.util.*;

public class _11404_플로이드 {
    static int N, M;
    static int INF = 9999999;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;

                if (i == j) map[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }

        floyd();

        sb = new StringBuilder();

        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= N ; j ++){
                if(map[i][j] == INF) map[i][j] = 0;

                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void floyd() {
        for(int k = 1 ; k <= N ; k ++){
            for(int i = 1 ; i <= N ; i ++) {
                for(int j = 1 ; j <= N ; j ++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}
