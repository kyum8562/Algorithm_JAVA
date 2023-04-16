package com.company;

import java.io.*;
import java.util.*;

public class _외판원순회2DFS {
    static class node {
        int r, c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, ans;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i, i,0, 0);
        }
        System.out.println(ans);
    }

    private static void DFS(int start, int curr, int depth, int sum) {
        if (depth == N - 1) {
            if (arr[curr][start] != 0) {
                sum += arr[curr][start];
                ans = Math.min(sum, ans);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[curr][i] > 0) {
                visited[i] = true;
                DFS(start, i, depth + 1, sum + arr[curr][i]);
                visited[i] = false;
            }

        }

    }
}


