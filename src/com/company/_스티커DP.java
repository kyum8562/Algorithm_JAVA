package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _스티커DP {
    static int T, N;
    static int[][] arr, DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < T ; i ++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[2][N+1];
            DP = new int[2][N+1];

            for(int j = 0 ; j < 2 ; j ++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= N ; k ++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            DP[0][0] = DP[1][0] = 0;
            DP[0][1] = arr[0][1];
            DP[1][1] = arr[1][1];

            for (int j = 2; j <= N; j++) {
                DP[0][j] = Math.max(DP[1][j - 1], DP[1][j - 2]) + arr[0][j];
                DP[1][j] = Math.max(DP[0][j - 1], DP[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(DP[0][N], DP[1][N]));
        }
    }
}


