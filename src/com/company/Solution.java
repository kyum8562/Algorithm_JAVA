package com.company;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += s.charAt(i) - '0';
        }

        System.out.println(ans);
    }
}
