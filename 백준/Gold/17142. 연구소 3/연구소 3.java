import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 14502 연구소2 - 구현
 * map에서 벽 3개를 조합으로 세우고, 안전영역 BFS 돌리면서 카운팅한 값들 중 최댓값 도출
 * map에서 0(빈칸) 1(벽) 2(바이러스)
 * <p>
 * 1. 입력 받기
 * 2. 벽 3개 세우기
 * 3. BFS 돌리고, 최댓값 갱신
 * 4. 2와 3 과정 반복
 * 5. 결과값 도출
 */
public class Main {
    static int N, M, ans, spareSpace, copySpareSpace, flag;
    static int[] combChoice;
    static int[][] map;
    static List<Virus> virusList;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Virus {
        int r;
        int c;
        int time;

        public Virus(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N*N 행렬
        M = Integer.parseInt(st.nextToken()); // 할당된 바이러스 수
        ans = Integer.MAX_VALUE;
        flag = 0;

        map = new int[N][N];
        combChoice = new int[M]; // 바이러스 리스트 중에서 M만큼 뽑아 담을 배열
        virusList = new ArrayList<>();
        spareSpace = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) spareSpace++;
                else if (map[i][j] == 2) virusList.add(new Virus(i, j, 0)); // 바이러스가 위치할 수 있는 공간
            }
        }

        if (spareSpace == 0) System.out.println(0);
        else {
            comb(0, 0); // 조합 돌리기
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans); // 최종값 도출
        }
    }

    private static void comb(int depth, int cnt) {
        // 바이러스를 둘 곳을 조합을 통해 뽑았다면
        if (depth == M) {
            bfs(spareSpace);
            return;
        }

        for (int i = cnt; i < virusList.size(); i++) {
            combChoice[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    private static void bfs(int localEmptySpace) {
        Queue<Virus> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][N];

        // 해당 map 값에 벽을 세움
        for (int i = 0; i < M; i++) {
            Virus curr = virusList.get(combChoice[i]);
            v[curr.r][curr.c] = true;
            q.offer(new Virus(curr.r, curr.c, 0));
        }

        while (!q.isEmpty()) {
            Virus curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (!isValid(nr, nc)) continue;
                if (v[nr][nc] || map[nr][nc] == 1) continue;

                if (map[nr][nc] == 0) localEmptySpace--;

                if (localEmptySpace == 0) {
                    ans = Math.min(ans, curr.time + 1);
                    return;
                }

                v[nr][nc] = true;
                q.offer(new Virus(nr, nc, curr.time + 1));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }
}