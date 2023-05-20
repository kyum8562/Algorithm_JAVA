package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class _부분수열의합 {
    static int N, M, ans = 0;
    static int[] arr;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        v = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        powerSet(0);
        System.out.println(ans);
    }

    private static void powerSet(int depth) {
        if (depth == N) {
            int sum = 0;
            boolean flag = false;
            for(int i = 0 ; i < N ; i ++) {
                if(v[i]){
                    sum += arr[i];
                    flag = true;
                }
            }
            if(sum == M && flag)
                ans++;
            return;
        }


        v[depth] = true;
        powerSet(depth + 1);

        v[depth] = false;
        powerSet(depth + 1);
    }
}
