package com.company;

import java.io.*;
import java.util.*;

public class prog_완주하지못한선수HashMap {
    static long N;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Boolean> map = new HashMap<>();

        N = Long.parseLong(st.nextToken());

        System.out.println(ans);
    }

}


