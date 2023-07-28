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
    static int[][] map, copyMap;
    static boolean[][] v;
    static List<Node> zeroList, virusList;
    static Queue<Node> q;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
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
        zeroList = new ArrayList<>();
        virusList = new ArrayList<>();
        spareSpace = N * N - M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) zeroList.add(new Node(i, j));
                else if (map[i][j] == 2) {
                    virusList.add(new Node(i, j)); // 바이러스가 위치할 수 있는 공간
                    map[i][j] = 0; // 바이러스 위치를 virusList에 담지만, 일단 map에는 0으로 할당
                } else if (map[i][j] == 1) spareSpace--;
            }
        }

        // 조합 돌리기
        comb(0, 0);

        // 최종값 도출
        System.out.println(flag == 1 ? ans-1 : -1);
    }

    private static void comb(int depth, int cnt) {
        // 바이러스를 둘 곳을 조합을 통해 뽑았다면
        if (depth == M) {
            // v 배열 초기화
            v = new boolean[N][N];

            // 맵 복사
            copyMap = new int[N][N];
            mapCopy();

            // 지역적으로 spareSpace를 copy한 카운트 변수
            copySpareSpace = spareSpace;
            // 지역적으로 bfs 돌리고 난 depth 카운트 변수
            int afterBfsVal = 0;

            q = new ArrayDeque<>();

            // 해당 map 값에 벽을 세움
            for (int i = 0; i < M; i++) {
                Node curr = virusList.get(combChoice[i]);
                // 뽑힌 바이러스의 위치의 copyMap값 만, 2로 배정
                copyMap[curr.r][curr.c] = 2;
                v[curr.r][curr.c] = true;
                q.offer(new Node(curr.r, curr.c));
            }

            // 바이러스(2) 이동
            afterBfsVal = bfs();

            // 최댓값 도출
//            maxModify();
            if (copySpareSpace == 0) {
                flag = 1;
                ans = Math.min(ans, afterBfsVal);
            }

            return;
        }

        for (int i = cnt; i < virusList.size(); i++) {
            combChoice[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    private static void mapCopy() {
        for (int i = 0; i < N; i++)
            copyMap[i] = map[i].clone();
    }

    private static int bfs() {
        int cnt = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node curr = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if (!isValid(nr, nc)) continue;
                    if (v[nr][nc]) continue;
                    v[nr][nc] = true;

                    if (copyMap[nr][nc] == 0) {
                        copyMap[nr][nc] = 2;
                        copySpareSpace--;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }
}