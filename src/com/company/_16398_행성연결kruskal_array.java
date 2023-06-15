package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _16398_행성연결kruskal_array {
    static int N;
    static long ans;
    static int[][] map;
    static int[] dist;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        dist = new int[N+1];
        v = new boolean[N+1];

        for(int i = 1 ; i <= N ;i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            dist[i] = Integer.MAX_VALUE;
        }
        br.close();

        dist[1] = 0;

        for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int j = 1; j <= N; j++) {
                if (!v[j] && min > dist[j]) {
                    min = dist[j];
                    minIdx = j;
                }
            }

            v[minIdx] = true;
            ans += min;
            for (int j = 1; j <= N; j++) {
                if (!v[j] && map[minIdx][j] != 0 && dist[j] > map[minIdx][j]) {
                    dist[j] = map[minIdx][j];
                }
            }

        }



        System.out.println(ans);
    }
}
