package com.company;

import java.io.*;
import java.util.*;

public class bfsdfs_nearMaxtrix {
    static int node, edge, vertax; // 정점개수, 간선개수, 탐색시작정점
    static boolean[] visited;
    static int[][] arr;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        vertax = Integer.parseInt(st.nextToken());

        visited = new boolean[node + 1];
        arr = new int[node + 1][node + 1];

        for(int i = 1 ; i <= edge ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(vertax);

        visited = new boolean[node + 1];
        System.out.println();
        bfs(vertax);
    }

    private static void bfs(int vertax) {
        q = new ArrayDeque<>();
        q.offer(vertax);
        visited[vertax] = true;
        while(!q.isEmpty()){
            vertax = q.poll();
            System.out.print(vertax + " ");
            for(int i = 1 ; i <= node; i ++){
                if(!visited[i] && arr[vertax][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private static void dfs(int vertax) {
        visited[vertax] = true;
        System.out.print(vertax + " ");
        for(int i = 1 ; i <= node ; i ++){
            if(!visited[i] && arr[vertax][i] == 1){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
