package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _123더하기_dp {
    static int N, ans;
    static int[] qArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        qArr = new int[11];

        qArr[1] = 1;
        qArr[2] = 2;
        qArr[3] = 4;

        for(int i = 4 ; i <= 10 ; i ++){
            qArr[i] = qArr[i-1] + qArr[i-2] + qArr[i-3];
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(qArr[n]);

        }

    }

}
