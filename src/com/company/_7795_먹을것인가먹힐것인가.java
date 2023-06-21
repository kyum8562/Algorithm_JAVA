package com.company;

import java.io.*;
import java.util.*;

public class _7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int ans = 0;
            int[] arr = new int[N];
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                arr2[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr2);
            int result = 0;

            for (int j = 0; j < N; j++) {
                int first = 0;
                int end = M - 1;
                int index = 0;

                while (first <= end) {
                    int mid = (first + end) / 2;
                    if (arr2[mid] < arr[j]) {
                        first = mid + 1;
                        index = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                result += index;
            }

            System.out.println(result);
        }
    }
}
