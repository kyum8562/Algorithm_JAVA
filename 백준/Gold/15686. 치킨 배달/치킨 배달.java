import java.io.*;
import java.util.*;

/**
 * BJ 15686 치킨배달 - 구현
 * 0 빈칸, 1 집, 2 치킨집
 * [풀이]
 * 입력을 받으면서 1(집)의 위치를 list에 저장
 * 2의 위치도 list에 저장해 놓고, 조합을 돌려서 M만큼 선택
 * M개의 선택된 치킨집 기준으로 BFS 탐색을 함
 * BFS 탐색을 하면서,
 * 1(집)을 발견 시에 해당 v배열에 거리 저장(visit 0이라면 방문하지 않은 것, 0이 아니라면 방문한 것)
 * 모두 순회 했을 경우 1에 해당하는 v 값을 다 더하고(sum)
 * ans(초기 값 INF)와 sum 중 최솟값 ans에 저장
 * <p>
 * 조합 횟수만큼 돌리고 결과값 ans 출력
 */
public class Main {
    static int N, M, ans, defaultChickenCnt, houseListCnt;
    static List<Node> houseList, chickenList;
    static int[] choiceChickenHouse;
    static int[][] map, v2;
    static boolean[][] v;
    static Queue<Node> q;

    static class Node {
        int r;
        int c;
        int d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        choiceChickenHouse = new int[M];
        map = new int[N + 1][N + 1];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houseList.add(new Node(i, j, 0));
                else if (map[i][j] == 2) chickenList.add(new Node(i, j, 0));
            }
        }

        defaultChickenCnt = chickenList.size();
        houseListCnt = houseList.size();

        // 폐업하지 않을 치킨집 선택 -> 조합
        comb(0, 0);

        System.out.println(ans);
    }

    /**
     * 폐업하지 않을 치킨집 선택: 조합 메서드
     *
     * @param depth 선택된 수
     * @param cnt
     */
    private static void comb(int depth, int cnt) {
        // 기저 조건
        if (depth == M) {
//            System.out.println(Arrays.toString(choiceChickenHouse));
            v2 = new int[N + 1][N + 1];
            for(int i = 0 ; i <= N ; i ++)
                Arrays.fill(v2[i], Integer.MAX_VALUE);

            // 큐에 뽑은 치킨집 넣어주기
            for (int i = 0; i < M; i++) {
                v = new boolean[N + 1][N + 1];
                q = new ArrayDeque<>();

                Node curr = chickenList.get(choiceChickenHouse[i]);
                q.offer(new Node(curr.r, curr.c, 0));
                v[curr.r][curr.c] = true;

                bfs();
            }

            int sum = 0;
                for (int i = 0; i < houseListCnt; i++){
                    Node curr = houseList.get(i);
                    sum += v2[curr.r][curr.c];
            }

            ans = Math.min(ans, sum);

            return;
        }

        for (int i = cnt; i < defaultChickenCnt; i++) {
            choiceChickenHouse[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(v2[curr.r][curr.c] > curr.d)
                v2[curr.r][curr.c] = curr.d;

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (!isValid(nr, nc)) continue;
                if (v[nr][nc]) continue;

                v[nr][nc] = true;

                q.offer(new Node(nr, nc, curr.d + 1));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 1 && nr <= N && nc >= 1 && nc <= N);
    }

}