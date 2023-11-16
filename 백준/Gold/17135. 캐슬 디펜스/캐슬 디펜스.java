import java.io.*;
import java.util.*;
public class Main {
    static int N, M, D, max = Integer.MIN_VALUE;
    static int[][] map, map2;
    static Queue<Node> q;
    static boolean[][] v;
    static int[] archer;
    static List<Node> killList;
    static class Node{
        int r;
        int c;
        int d;
        public Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 뽑기
        archer = new int[3];
        comb(0, 1);
        System.out.println(max);
    }

    private static void comb(int depth, int cnt) {
        if(depth == 3){
            max = Math.max(max, attacking()); // 궁수가 공격
            return;
        }
        for(int i = cnt ; i <= M ; i ++){
            archer[depth] = i;
            comb(depth+1, i+1);
        }
    }

    private static int attacking() {
        int killCnt = 0; // 궁수 3명이 적을 죽인 수
        int stage = 0; // stage 진행도

        mapCopy(); // map 복사

        while(stage <= N){
            // stage 진행
            killList = new ArrayList<>(); // 궁수가 쏠 타겟 저장

            for(int i = 0 ; i < 3 ; i ++){ // 궁수가 죽일 적군을 리스트에 넣기
                int r = N;
                int c = archer[i];
                v = new boolean[N+1][M+1];
                v[r][c] = true;
                q = new ArrayDeque<>();
                q.offer(new Node(r, c, 1));

                outer: while(!q.isEmpty()){ // bfs 탐색
                    Node curr = q.poll();
                    if(curr.d > D) break; // 사거리(D)보다 크다면 break
                    if(map2[curr.r][curr.c] == 1){
                        killList.add(new Node(curr.r, curr.c, 0));
                        break outer;
                    }

                    for(int d = 0 ; d < 3 ; d ++){
                        int nr = curr.r + dr[d];
                        int nc = curr.c + dc[d];

                        if(!isValid(nr, nc) || v[nr][nc]) continue;
                        q.offer(new Node(nr, nc, curr.d +1));
                    }
                }
            }

            // 적군 죽이기
            for(Node curr: killList){
                if(map2[curr.r][curr.c] == 1) killCnt++;
                map2[curr.r][curr.c] = 0;
            }

            moving(); // 모든 적들 한칸 이동
            stage++;
        }

        return killCnt;
    }

    private static void mapCopy() {
        map2 = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= M ; j ++)
                map2[i][j] = map[i][j];
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=1 && nr<=N && nc>=1 && nc<=M);
    }

    private static void moving() {
        for(int i = N-1 ; i >= 0 ; i --){
            for(int j = 1 ; j <= M ; j ++){
                map2[i+1][j] = map2[i][j];
                map2[i][j] = 0;
            }
        }

    }
}