package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _순열사이클DFS {
    static int N, ans;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[2][N + 1];
            visited = new boolean[N + 1];
            ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[0][i] = i;
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                visited[i] = true;
                DFS(i, i);
            }
            System.out.println(ans);
        }
    }

    private static void DFS(int start, int curr) {
        if (arr[0][start] == arr[1][curr]) {
            ans++;
            return;
        }

        int tmp = arr[1][arr[0][curr]];
        if (!visited[tmp]) {
            visited[tmp] = true;
            DFS(start, arr[1][arr[0][curr]]);
        }
    }
}


