import java.io.*;
import java.util.*;
public class Main {
    static int N, M, ans, defaultChickenCnt, houseListCnt;
    static List<Node> houseList, chickenList;
    static boolean[] choiceChickenHouse;
    static int[][] map;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
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

        choiceChickenHouse = new boolean[defaultChickenCnt];

        comb(0, 0);

        System.out.println(ans);
    }
    private static void comb(int depth, int cnt) {
        if (depth == M) {
            int[] arr = new int[houseListCnt];
            Arrays.fill(arr, Integer.MAX_VALUE);

            for (int i = 0; i < defaultChickenCnt; i++) {
                if(!choiceChickenHouse[i]) continue;
                Node currChickenHouse = chickenList.get(i);
                for (int j = 0; j < houseListCnt; j++) {
                    Node currHouse = houseList.get(j);

                    int tmp = Math.abs(currChickenHouse.r - currHouse.r) + Math.abs(currChickenHouse.c - currHouse.c);
                    arr[j] = Math.min(arr[j], tmp);
                }
            }

            int sum = 0;
            for(int i = 0 ; i < houseListCnt ; i ++) sum += arr[i];

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = cnt; i < defaultChickenCnt; i++) {
            if(choiceChickenHouse[i]) continue;
            choiceChickenHouse[i] = true;
            comb(depth + 1, i + 1);
            choiceChickenHouse[i] = false;
        }
    }
}