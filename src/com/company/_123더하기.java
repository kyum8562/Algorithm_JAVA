package com.company;

import java.io.*;
import java.util.*;

public class _123더하기 {
    static int N, ans;
    static int[] qArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        qArr = new int[N];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            qArr[i] = Integer.parseInt(st.nextToken());

            ans = 0;
            play(1, qArr[i]);
            play(2, qArr[i]);
            play(3, qArr[i]);
            System.out.println(ans);
        }
    }

    private static void play(int curr, int standard) {
        if(curr > standard) return;
        else if(curr == standard){
                ans++;
        }
        play(1 + curr, standard);
        play(2 + curr, standard);
        play(3 + curr, standard);
    }
}
