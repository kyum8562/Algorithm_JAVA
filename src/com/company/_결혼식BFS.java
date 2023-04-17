package com.company;

import java.io.*;
import java.util.*;

public class _결혼식BFS {
    static int N, R, ans;
    static int[][] arr;
    static boolean[] v;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        v = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        bfs();

        for (boolean val : v) {
            if (val) ans++;
        }
        System.out.println(ans);
    }

    private static void bfs() {
        for(int i = 2 ; i <= N ; i ++){
            if(arr[1][i] == 0) continue;
            v[i] = true;
            for(int j = 2 ; j <= N ; j ++){
                if(!v[j] && arr[i][j] == 1){
                    v[j] = true;
                }
            }
        }
    }
}


