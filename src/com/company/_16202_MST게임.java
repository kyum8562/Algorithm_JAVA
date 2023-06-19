package com.company;

import java.io.*;
import java.util.*;

public class _16202_MST게임 {
    static int N, M, K;
    static List<Node> graph;
    static int[] parents;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        graph = new ArrayList<>();


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.add(new Node(s, e, i));
        }

//        Collections.sort(graph);

        int tmp = 0;
        for (int turn = 0; turn < K; turn++) {
            for (int i = 1; i <= N; i++) parents[i] = i;
            int ans = 0;

            for (int i = turn; i < M; i++) {
                Node curr = graph.get(i);

                if (find(curr.start) != find(curr.end)) {
                    ans += curr.dist;
                    union(curr.start, curr.end);
                }

            }
            boolean flag = true;
            int firstNum = find(1);
            for (int i = 1; i <= N; i++) {
                if (firstNum != find(i)) {
                    flag = false;
                    break;
                }
            }

            tmp++;
            if(flag){
                System.out.print(ans + " ");
            }
            else{
                for(int i = turn+1 ; i < K ; i ++){
                    System.out.print(0 + " ");
                }
            }
//            System.out.print(flag ? ans + " " : 0 + " ");
        }

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
        else parents[x] = y;

    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
}

