package com.company;

import java.io.*;
import java.util.*;

public class ppch {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];

        PPCH(0, 1);
    }

    private static void PPCH(int depth, int cnt) {
        if(depth == M){
            for(int i = 0 ; i < arr.length ; i ++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = cnt ; i <= N ; i ++){
//            if(visited[i]) continue;
//            visited[i] = true;
            arr[depth] = i;
            PPCH(depth+1, cnt);
//            visited[i] = false;
        }
    }
}
