import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    static int[][] map, mapTmp;
    static PriorityQueue<Node> q;

    static class Node implements Comparable<Node> {
        int idx;
        int v;

        public Node(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            if (this.v == o.v) return this.idx - o.idx;
            else return this.v - o.v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        map = new int[201][201];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int stage = 0, rCnt = 3, cCnt = 3;
        while (true) {
            // 종료조건
            if (stage == 101) {
                System.out.println(-1);
                break;
            }
            if (map[R][C] == K) {
                System.out.println(stage);
                break;
            }

            mapTmp = new int[201][201];

            if (rCnt >= cCnt) { // 모든 행 정렬
                int maxCnt = 0;
                for (int i = 0; i < rCnt; i++) {
                    int[] v = new int[101];
                    int cnt = 0;

                    for (int j = 0; j < cCnt; j++) { // 해당 row 숫자 카운팅
                        v[map[i][j]]++;
                    }

                    q = new PriorityQueue<>();
                    for (int j = 1; j <= 100; j++) { // 우선 순위 큐에 (인덱스, 카운트) 저장
                        if (v[j] > 0) {
                            q.offer(new Node(j, v[j]));
                            cnt++;
                        }
                    }
                    maxCnt = Math.max(maxCnt, cnt);

                    int idx = 0;
                    while(!q.isEmpty()){
                        Node curr = q.poll(); // 정렬된 순서대로 mapTmp에 저장
                        mapTmp[i][idx++] = curr.idx;
                        mapTmp[i][idx++] = curr.v;
                    }
                }

                maxCnt = maxCnt*2 > 100 ? 100 : maxCnt*2;
                for(int i = 0 ; i < rCnt ; i ++){
                    for(int j = 0 ; j < maxCnt ; j ++){
                        map[i][j] = mapTmp[i][j];
                    }
                }
                cCnt = maxCnt;

            }
            else{
                int maxCnt = 0;
                for (int j = 0; j < cCnt; j++) {
                    int[] v = new int[101];
                    int cnt = 0;

                    for (int i = 0; i < rCnt; i++) { // 해당 col 숫자 카운팅
                        v[map[i][j]]++;
                    }

                    q = new PriorityQueue<>();
                    for (int i = 1; i <= 100; i++) { // 우선 순위 큐에 (인덱스, 카운트) 저장
                        if (v[i] > 0) {
                            q.offer(new Node(i, v[i]));
                            cnt++;
                        }
                    }
                    maxCnt = Math.max(maxCnt, cnt);

                    int idx = 0;
                    while(!q.isEmpty()){
                        Node curr = q.poll(); // 정렬된 순서대로 mapTmp에 저장
                        mapTmp[idx++][j] = curr.idx;
                        mapTmp[idx++][j] = curr.v;
                    }
                }
                maxCnt = maxCnt*2 > 100 ? 100 : maxCnt*2;
                for(int i = 0 ; i < maxCnt ; i ++){
                    for(int j = 0 ; j < cCnt ; j ++){
                        map[i][j] = mapTmp[i][j];
                    }
                }
                rCnt = maxCnt;
            }
            stage++;
        }
    }
}