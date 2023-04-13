package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모든순열 {
    static int N;
    static int[] arr, arr2;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        arr2 = new int[N];

        for(int i = 1 ; i <= N ; i ++)
            arr[i-1] = i;

        perm(0);
        System.out.println(sb.toString());
    }

    private static void perm(int cnt) {
        if(cnt == N){
            for(int i : arr2){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < N ; i ++){
            if(visited[i]) continue;
            visited[i] = true;
            arr2[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
