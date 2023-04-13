package com.company;

import java.io.*;
import java.util.*;

public class _유기농배추BFS {
    static class node{
        int r, c;
        public node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int T, N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Queue<node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < T ; i ++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];
            int cnt = 0;

            for(int j = 0 ; j < K ; j ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            for(int j = 0 ; j < N ; j ++){
                for(int k = 0 ; k < M ; k ++) {
                    if(!visited[j][k] && arr[j][k] == 1){
//                        BFS(j, k);
                        DFS(j, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void DFS(int j, int k) {
        visited[j][k] = true;

        for(int d = 0 ; d < 4 ; d ++){
            int nr = dr[d] + j;
            int nc = dc[d] + k;

            if(nr>= 0 && nr<N && nc >= 0 && nc <M){
                if(!visited[nr][nc] && arr[nr][nc] == 1)
                    DFS(nr, nc);
            }
        }
    }

    private static void BFS(int j, int k) {
        q = new ArrayDeque<>();
        visited[j][k] = true;
        q.offer(new node(j, k));

        while(!q.isEmpty()){
            node curr = q.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;
                if(nr>= 0 && nr<N && nc >= 0 && nc <M){
                    if(!visited[nr][nc] && arr[nr][nc] == 1){
                        visited[nr][nc] = true;
                        q.offer(new node(nr, nc));
                    }
                }
            }

        }
    }
}


